/**
 * Project Name:gradle
 * File Name:Application.java
 * Package Name:web
 * Date:2017年2月27日上午11:35:34
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package jp.co.btc.hrms;

import jp.co.btc.hrms.config.DatabaseProperties;
import jp.co.btc.hrms.config.JerseyConfig;
import jp.co.btc.hrms.config.RedisProperties;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "jp.co.btc.hrms.dao",
                                  "jp.co.btc.hrms.service",
                                  "jp.co.btc.hrms.domain",
                                  "jp.co.btc.hrms.config" })
@EnableJpaRepositories("jp.co.btc.hrms.dao")
@EntityScan(basePackages = { "jp.co.btc.hrms.domain" })
@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigurationProperties({ RedisProperties.class, DatabaseProperties.class })
public class Application {

  /**
   * .
   * @return ServletRegistrationBean
   */
  @Bean
  public ServletRegistrationBean jerseyServlet() {
    ServletRegistrationBean registration =
        new ServletRegistrationBean(new ServletContainer(), "/rest/*");

    registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
                                  JerseyConfig.class.getName());
    return registration;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
