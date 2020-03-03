# -*- coding: utf-8 -*-

from __future__ import print_function

import re
import subprocess
import sys

from ..external import six


REQ_SPEC_PATTERN = (
    r"([A-Z0-9]|[A-Z0-9][A-Z0-9._-]*[A-Z0-9])\s*"  # https://www.python.org/dev/peps/pep-0508/#names
    r"(~=|==|!=|<=|>=|<|>|===)\s*"  # https://www.python.org/dev/peps/pep-0440/#version-specifiers
    r"([0-9]+(?:\.[0-9]){0,2}).*$"
)
REQ_SPEC_REGEX = re.compile(REQ_SPEC_PATTERN, flags=re.IGNORECASE)


def get_pip_freeze():
    pip_freeze = subprocess.check_output([sys.executable, '-m', 'pip', 'freeze'])
    pip_freeze = six.ensure_str(pip_freeze)

    reqs = pip_freeze.splitlines()

    # remove libraries installed through a VCS
    # TODO: upgrade our protos to support handling these
    reqs = list(filter(lambda req: not is_vcs_req(req), reqs))

    return reqs


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
        raise ValueError("\"{}\" does not appear to be a valid pip requirement specifier".format(req_spec))

    return match.groups()


def parse_version(version):
    """
    Parses a version number into its components.

    Anything more specific than the patch version will be ignored.

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

    """
    components = version.split('.')

    if len(components) > 3:
        raise ValueError("\"{}\" does not appear to be a valid version number".format(version))

    # remove anything more specific than patch version
    if len(components) == 3:
        components[2] = re.match(r"^[0-9]+", components[2]).group()

    major = int(components[0])
    minor = int(components[1]) if len(components) >= 2 else 0
    patch = int(components[2]) if len(components) == 3 else 0

    return major, minor, patch


def is_vcs_req(req_spec):
    # https://pip.pypa.io/en/stable/reference/pip_install/#vcs-support
    return req_spec.startswith(('-e ', 'git:', 'git+', 'hg+', 'svn+', 'bzr+'))
