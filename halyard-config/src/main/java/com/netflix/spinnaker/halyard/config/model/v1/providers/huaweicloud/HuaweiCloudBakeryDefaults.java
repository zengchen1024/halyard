package com.netflix.spinnaker.halyard.config.model.v1.providers.huaweicloud;

import com.netflix.spinnaker.halyard.config.model.v1.node.BakeryDefaults;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HuaweiCloudBakeryDefaults extends BakeryDefaults<HuaweiCloudBaseImage> {

  private String authUrl;
  private String domainName;
  private String networkId;
  private String floatingIpPool;
  private String securityGroups;
  private String projectName;
  private String username;
  private String password;
  private Boolean insecure;
}
