package jp.co.btc.hrms.config;

import java.util.Set;
import java.util.regex.Pattern;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.filter.RequestContextFilter;

@Component
public class JerseyConfig extends ResourceConfig {

  /**
   * .
   *
   *
   */
  public JerseyConfig() {
    register(RequestContextFilter.class);
    // packages("rest");
    ClassPathScanningCandidateComponentProvider provider =
        new ClassPathScanningCandidateComponentProvider(false);

    provider.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*")));

    Set<BeanDefinition> candidateComponents =
        provider.findCandidateComponents("rest");

    for (BeanDefinition candidateComponent : candidateComponents) {
      register(ClassUtils.resolveClassName(
          candidateComponent.getBeanClassName(),
          ClassUtils.getDefaultClassLoader()));
    }
    // register(LoggingFilter.class);
  }
}
