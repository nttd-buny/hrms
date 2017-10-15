
package jp.co.btc.hrms.config;

import lombok.Data;
import lombok.ToString;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.database")
@Data
@ToString
public class DatabaseProperties {
  private String url;
  private String username;
  private String password;
  private String driverClassName;
}
