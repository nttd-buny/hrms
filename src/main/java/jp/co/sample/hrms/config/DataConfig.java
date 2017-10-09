package jp.co.sample.hrms.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataConfig {

   @Bean
   public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception{
       SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
       factory.setDataSource(dataSource);
       factory.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));
       return factory;
   }

   @Bean
   @Autowired
   protected PlatformTransactionManager createTransactionManager(DataSource dataSource) {
       return new DataSourceTransactionManager(dataSource);
   }
}