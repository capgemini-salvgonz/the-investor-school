
package com.tis.mx.infraestructure.configuration;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.tis.mx.application.service.InvestorSchoolService;
import com.tis.mx.application.service.impl.InvestorSchoolServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public InvestorSchoolService investorSchoolService(DiscoveryClient discoveryClient) {
    return new InvestorSchoolServiceImpl(discoveryClient);
  }
}
