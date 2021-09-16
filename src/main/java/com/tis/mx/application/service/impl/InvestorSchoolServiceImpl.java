package com.tis.mx.application.service.impl;

import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.repository.BaseLineServiceRepository;
import com.tis.mx.application.service.InvestorSchoolService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.hystrix.HystrixFeign;

@Service
public class InvestorSchoolServiceImpl implements InvestorSchoolService {

  private BaseLineServiceRepository baseLineRepository;
  
  public InvestorSchoolServiceImpl() {
    this.baseLineRepository = HystrixFeign.builder()
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .target(BaseLineServiceRepository.class, "http://localhost:8080");
  }
  
  @Override
  public List<InvestmentYieldDto> createSimulation(InitialInvestmentDto initialInvestment) {

    Map<String,String> header = new HashMap<>();
    header.put("Content-Type", "application/json");
    
    return this.baseLineRepository.postCalculatorCi(header, initialInvestment);
  }

}
