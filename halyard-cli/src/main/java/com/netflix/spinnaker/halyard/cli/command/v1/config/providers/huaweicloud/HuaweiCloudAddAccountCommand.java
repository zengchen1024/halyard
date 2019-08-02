package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.huaweicloud;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.account.AbstractAddAccountCommand;
import com.netflix.spinnaker.halyard.cli.command.v1.converter.LocalFileConverter;
import com.netflix.spinnaker.halyard.config.model.v1.node.Account;
import com.netflix.spinnaker.halyard.config.model.v1.providers.huaweicloud.HuaweiCloudAccount;
import java.util.ArrayList;
import java.util.List;

@Parameters(separators = "=")
public class HuaweiCloudAddAccountCommand extends AbstractAddAccountCommand {
  protected String getProviderName() {
    return "huaweicloud";
  }

  @Parameter(
      names = "--account-type",
      description = HuaweiCloudCommandProperties.ACCOUNT_TYPE_DESCRIPTION)
  private String accountType;

  @Parameter(
      names = "--auth-url",
      required = true,
      description = HuaweiCloudCommandProperties.AUTH_URL_DESCRIPTION)
  private String authUrl;

  @Parameter(
      names = "--username",
      required = true,
      description = HuaweiCloudCommandProperties.USERNAME_DESCRIPTION)
  private String username;

  @Parameter(
      names = "--password",
      required = true,
      description = HuaweiCloudCommandProperties.PASSWORD_DESCRIPTION)
  private String password;

  @Parameter(
      names = "--project-name",
      required = true,
      description = HuaweiCloudCommandProperties.PROJECT_NAME_DESCRIPTION)
  private String projectName;

  @Parameter(
      names = "--domain-name",
      required = true,
      description = HuaweiCloudCommandProperties.DOMAIN_NAME_DESCRIPTION)
  private String domainName;

  @Parameter(
      names = "--regions",
      required = true,
      variableArity = true,
      description = HuaweiCloudCommandProperties.REGIONS_DESCRIPTION)
  private List<String> regions = new ArrayList<>();

  @Parameter(names = "--insecure", description = HuaweiCloudCommandProperties.INSECURE_DESCRIPTION)
  private boolean insecure;

  @Parameter(
      names = "--asg-config-location",
      converter = LocalFileConverter.class,
      description = HuaweiCloudCommandProperties.HEAT_TEMPLATE_LOCATION_DESCRIPTION)
  private String asgConfigLocation;

  @Parameter(
      names = "--consul-config",
      converter = LocalFileConverter.class,
      description = HuaweiCloudCommandProperties.CONSUL_CONFIG_DESCRIPTION)
  private String consulConfig;

  @Parameter(
      names = "--user-data-file",
      converter = LocalFileConverter.class,
      description = HuaweiCloudCommandProperties.USER_DATA_FILE_DESCRIPTION)
  private String userDataFile;

  @Parameter(
      names = "--lbaas-poll-timeout",
      description = HuaweiCloudCommandProperties.LBAAS_POLL_TIMEOUT_DESCRIPTION)
  private Integer lbaasPollTimeout;

  @Parameter(
      names = "--lbaas-poll-interval",
      description = HuaweiCloudCommandProperties.LBAAS_POLL_INTERVAL_DESCRIPTION)
  private Integer lbaasPollInterval;

  @Override
  protected Account buildAccount(String accountName) {

    HuaweiCloudAccount.LBOptions lbaas = new HuaweiCloudAccount.LBOptions();
    if (isSet(lbaasPollInterval)) {
      lbaas.setPollInterval(lbaasPollInterval);
    }
    if (isSet(lbaasPollTimeout)) {
      lbaas.setPollTimeout(lbaasPollTimeout);
    }

    HuaweiCloudAccount account = (HuaweiCloudAccount) new HuaweiCloudAccount().setName(accountName);
    account
        .setAuthUrl(authUrl)
        .setUsername(username)
        .setPassword(password)
        .setAccountType(accountType)
        .setAsgConfigLocation(asgConfigLocation)
        .setProjectName(projectName)
        .setDomainName(domainName)
        .setRegions(regions)
        .setInsecure(insecure)
        .setUserDataFile(userDataFile)
        .setConsulConfig(consulConfig)
        .setLbOptions(lbaas);

    return account;
  }

  @Override
  protected Account emptyAccount() {
    return new HuaweiCloudAccount();
  }
}
