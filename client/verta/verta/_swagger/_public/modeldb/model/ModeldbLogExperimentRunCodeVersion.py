# THIS FILE IS AUTO-GENERATED. DO NOT EDIT

class ModeldbLogExperimentRunCodeVersion(dict):
  def __init__(self, id=None, code_version=None, overwrite=None):
    self.id = id
    self.code_version = code_version
    self.overwrite = overwrite

  def __setattr__(self, name, value):
    self[name] = value

  def __delattr__(self, name):
    del self[name]

  def __getattr__(self, name):
    if name in self:
      return self[name]
    else:
      raise AttributeError
