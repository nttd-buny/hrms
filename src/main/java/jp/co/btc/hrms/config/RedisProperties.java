package jp.co.btc.hrms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisProperties {

  private String database;
  private String host;
  private String post;
  private String password;

  @Override
  public String toString() {
    return "RedisProperties [database=" + database + ", host=" + host + ", post=" + post + ", password=" + password
        + "]";
  }

}
