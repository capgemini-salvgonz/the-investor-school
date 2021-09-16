package com.tis.mx.application.service.impl;

import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.repository.BaseLineServiceRepository;
import com.tis.mx.application.service.InvestorSchoolService;
import org.springframework.stereotype.Service;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.hystrix.HystrixFeign;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InvestorSchoolServiceImpl implements InvestorSchoolService {

  private BaseLineServiceRepository baseLineRepository;
  private static final String APPLICATION_NAME = "BASELINE-SERVICE-SGN";
  private DiscoveryClient discoveryClient;
  
  public InvestorSchoolServiceImpl(DiscoveryClient discoveryClient) {
    this.discoveryClient = discoveryClient;
  }
  
  public void createHttpClient(String host) {
    
    this.baseLineRepository = HystrixFeign.builder()
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .target(BaseLineServiceRepository.class, host);
  }
  
  public String getHost() {
    
    String hostName = discoveryClient.getInstances(APPLICATION_NAME).get(0).getUri().toString();
    
    log.info(hostName);
    return hostName;
  }
  
  @Override
  public List<InvestmentYieldDto> createSimulation(InitialInvestmentDto initialInvestment) {
    
    this.createHttpClient(this.getHost());
    
    Map<String,String> header = new HashMap<>();
    header.put("Content-Type", "application/json");
    
    return this.baseLineRepository.postCalculatorCi(header, initialInvestment);
  }

}
