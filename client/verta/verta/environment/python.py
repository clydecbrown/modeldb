# -*- coding: utf-8 -*-

from __future__ import print_function

import sys

from .._protos.public.modeldb.versioning import Environment_pb2 as _EnvironmentService

from . import _environment
from . import _environment_utils


class Python(_environment.Environment):
    def __init__(self, requirements=None, env_vars=None):
        """


        Parameters
        ----------
        requirements : list of str, optional
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
        else:
            raise NotImplementedError

        for req_spec in req_specs:
            library, constraint, version = _environment_utils.parse_req_spec(req_spec)
            major, minor, micro = _environment_utils.parse_version(version)

            req_blob_msg = _EnvironmentService.PythonRequirementEnvironmentBlob()
            req_blob_msg.library = library
            req_blob_msg.constraint = constraint
            req_blob_msg.version.major = major
            req_blob_msg.version.minor = minor
            req_blob_msg.version.patch = micro

            self._msg.python.requirements.append(req_blob_msg)
