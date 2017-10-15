/**
 * Project Name:spring-boot
 * File Name:ApplicationProperties.java
 * Package Name:config
 * Date:2017年2月27日下午5:12:27
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package jp.co.btc.hrms.config;

import lombok.Data;
import lombok.ToString;

//@ConfigurationProperties(prefix = "spring.dev",locations)
@Data
@ToString
public class DevProperties {
  private String url;
  private String username;
  private String password;
  private String driverClassName;
}
