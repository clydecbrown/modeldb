import pytest

import os
import subprocess
import sys
import tempfile

import six

import utils

import verta.environment
from verta.environment import _environment_utils


pytest.skip("unstable back end support", allow_module_level=True)


class TestUtils:
    def test_parse_pip_freeze(self):
        req_specs = _environment_utils.get_pip_freeze()
        parsed_req_specs = (
            (library, constraint, _environment_utils.parse_version(version))
            for library, constraint, version
            in map(_environment_utils.parse_req_spec, req_specs)
        )

        for library, constraint, parsed_version in parsed_req_specs:
            assert library != ""
            assert ' ' not in library

            assert constraint in ('~=', '==', '!=', '<=', '>=', '<', '>', '===')

            assert parsed_version[0] >= 0  # major
            assert parsed_version[1] >= 0  # minor
            assert parsed_version[2] >= 0  # patch
            assert isinstance(parsed_version[3], six.string_types)  # suffix


class TestPython:
    def test_reqs_from_env(self):
        env = verta.environment.Python()
        assert env._msg.python.requirements

    def test_reqs_from_list(self):
        pytest.importorskip("sklearn")

        env = verta.environment.Python(requirements=['sklearn'])
        req_msg = env._msg.python.requirements[0]
        assert req_msg.library == "scikit-learn"
        assert req_msg.constraint == '=='

    def test_reqs_from_file(self):
        with tempfile.TemporaryFile('w+') as tempf:
            # create requirements file from pip freeze
            pip_freeze = subprocess.check_output([sys.executable, '-m', 'pip', 'freeze'])
            pip_freeze = six.ensure_str(pip_freeze)
            tempf.write(pip_freeze)
            tempf.flush()  # flush object buffer
            os.fsync(tempf.fileno())  # flush OS buffer
            tempf.seek(0)

            env = verta.environment.Python(requirements=tempf)
            assert env._msg.python.requirements
