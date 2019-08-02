package com.netflix.spinnaker.halyard.config.validate.v1.providers.huaweicloud;

import com.netflix.spinnaker.halyard.config.model.v1.node.Validator;
import com.netflix.spinnaker.halyard.config.model.v1.providers.huaweicloud.HuaweiCloudProvider;
import com.netflix.spinnaker.halyard.config.problem.v1.ConfigProblemSetBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HuaweiCloudProviderValidator extends Validator<HuaweiCloudProvider> {
  @Autowired private String halyardVersion;

  @Override
  public void validate(ConfigProblemSetBuilder p, HuaweiCloudProvider n) {}
}
