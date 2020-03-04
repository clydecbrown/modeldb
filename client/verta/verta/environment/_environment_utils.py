# -*- coding: utf-8 -*-

from __future__ import print_function

import re
import subprocess
import sys

from ..external import six


VER_NUM_PATTERN = r"^([0-9]+(?:\.[0-9]+){0,2}[^\s]*)$"  # https://www.python.org/dev/peps/pep-0440/#version-scheme
REQ_SPEC_PATTERN = (
    r"^([A-Z0-9]|[A-Z0-9][A-Z0-9._-]*[A-Z0-9])\s*"  # https://www.python.org/dev/peps/pep-0508/#names
    + r"(~=|==|!=|<=|>=|<|>|===)\s*"  # https://www.python.org/dev/peps/pep-0440/#version-specifiers
    + VER_NUM_PATTERN[1:]  # skip start-of-string
)
VER_NUM_REGEX = re.compile(VER_NUM_PATTERN)
REQ_SPEC_REGEX = re.compile(REQ_SPEC_PATTERN, flags=re.IGNORECASE)


def get_pip_freeze():
    pip_freeze = subprocess.check_output([sys.executable, '-m', 'pip', 'freeze'])
    pip_freeze = six.ensure_str(pip_freeze)

    req_specs = pip_freeze.splitlines()

    # remove libraries installed through a VCS
    # TODO: upgrade protos and Client to handle these
    req_specs = list(filter(lambda req: not is_vcs_req(req), req_specs))

    return req_specs


def parse_req_spec(req_spec):
    """
    Parses a requirement specifier into its components.

    Parameters
    ----------
    req_spec : str
        e.g. "banana >= 3.6.0"

    Returns
    -------
    library : str
        e.g. "banana"
    constraint : str
        e.g. ">="
    version : str
        e.g. "3.6.0"

    """
    match = REQ_SPEC_REGEX.match(req_spec)
    if match is None:
        raise ValueError("\"{}\" does not appear to be a valid pip requirement specifier;"
                         " it may be misspelled or missing its version specifier".format(req_spec))

    return match.groups()


def parse_version(version):
    """
    Parses a version number into its components.

    A missing component will be returned as a ``0``.

    Parameters
    ----------
    version : str
        e.g. "3.6"

    Returns
    -------
    major : int
        e.g. 3
    minor : int
        e.g. 6
    patch : int
        e.g. 0
    suffix : str
        Additional characters, such as build metadata or sub-patch release numbers.

    """
    if VER_NUM_REGEX.match(version) is None:
        raise ValueError("\"{}\" does not appear to be a valid version number".format(version))

    # exercise for the reader: implement this function with one regex
    MAJOR_REGEX = re.compile(r"^([0-9]+)")
    MINOR_OR_PATCH_REGEX = re.compile(r"^(\.[0-9]+)")

    # extract major version
    split = MAJOR_REGEX.split(version, maxsplit=1)[1:]  # first element is empty
    major = int(split[0])
    suffix = ''.join(split[1:])

    # extract minor version
    if MINOR_OR_PATCH_REGEX.match(suffix):
        split = MINOR_OR_PATCH_REGEX.split(suffix, maxsplit=1)[1:]  # first element is empty
        minor = int(split[0][1:])  # first character is period
        suffix = ''.join(split[1:])
    else:
        minor = 0

    # extract patch version
    if MINOR_OR_PATCH_REGEX.match(suffix):
        split = MINOR_OR_PATCH_REGEX.split(suffix, maxsplit=1)[1:]  # first element is empty
        patch = int(split[0][1:])  # first character is period
        suffix = ''.join(split[1:])
    else:
        patch = 0

    return major, minor, patch, suffix


def is_vcs_req(req_spec):
    # https://pip.pypa.io/en/stable/reference/pip_install/#vcs-support
    return req_spec.startswith(('-e ', 'git:', 'git+', 'hg+', 'svn+', 'bzr+'))
