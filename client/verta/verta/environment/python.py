# -*- coding: utf-8 -*-

from __future__ import print_function

import copy
import sys

from ..external import six

from .._protos.public.modeldb.versioning import Environment_pb2 as _EnvironmentService

from .. import _artifact_utils

from . import _environment
from . import _environment_utils


class Python(_environment.Environment):
    def __init__(self, requirements=None, env_vars=None):
        """


        Parameters
        ----------
        requirements : list of str or file-like, optional
            Either a list of PyPI package names, or a handle to a pip requirements file. If not
            provided, all packages currently installed through pip will be captured.
        env_vars : list of str, optional
            Names of environment variables to capture. If not provided, nothing will be captured.

        """
        super(Python, self).__init__(env_vars=env_vars)
        self._capture_py_ver()
        self._capture_reqs(requirements)

    def _capture_py_ver(self):
        self._msg.python.version.major = sys.version_info.major
        self._msg.python.version.minor = sys.version_info.minor
        self._msg.python.version.patch = sys.version_info.micro

    def _capture_reqs(self, requirements):
        if requirements is None:
            # TODO: support conda
            req_specs = _environment_utils.get_pip_freeze()
        elif (isinstance(requirements, list)
              and all(isinstance(req, six.string_types) for req in requirements)):
            req_specs = copy.copy(requirements)

            # replace importable module names with PyPI package names in case of user error
            for i, req in enumerate(req_specs):
                req_specs[i] = _artifact_utils.IMPORT_TO_PYPI.get(req, req)

            _artifact_utils.set_version_pins(req_specs)
        elif hasattr(requirements, 'read'):
            req_specs = _artifact_utils.read_reqs_file_lines(requirements)
            _artifact_utils.set_version_pins(req_specs)
        else:
            raise TypeError("`requirements` must be either list of str or file-like,"
                            " not {}".format(type(requirements)))

        for req_spec in req_specs:
            library, constraint, version = _environment_utils.parse_req_spec(req_spec)
            major, minor, patch, suffix = _environment_utils.parse_version(version)

            req_blob_msg = _EnvironmentService.PythonRequirementEnvironmentBlob()
            req_blob_msg.library = library
            req_blob_msg.constraint = constraint
            req_blob_msg.version.major = major
            req_blob_msg.version.minor = minor
            req_blob_msg.version.patch = patch
            req_blob_msg.version.suffix = suffix

            self._msg.python.requirements.append(req_blob_msg)
