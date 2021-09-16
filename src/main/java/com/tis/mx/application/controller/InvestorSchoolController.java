package com.tis.mx.application.controller;

import com.tis.mx.application.controller.exception.ForbiddenException;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.InvestorSchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class InvestorSchoolController {

  private InvestorSchoolService investorSchoolService;

  private static final String SERVICE_KEY = "bbd219cc-488c-4911-b10f-592480b45ffc";

  public InvestorSchoolController(InvestorSchoolService investorSchoolService) {
    this.investorSchoolService = investorSchoolService;
  }

  @PostMapping(value = "/api/v1/investors/school/simulations")
  public ResponseEntity<List<InvestmentYieldDto>> createSimulation(
      @RequestHeader(value = "Authorization") String authorization,
      @RequestBody InitialInvestmentDto initialInvestment) {

    if (SERVICE_KEY.equals(authorization)) {
      return new ResponseEntity<>(this.investorSchoolService.createSimulation(initialInvestment),
          HttpStatus.OK);
    }
    
    throw new ForbiddenException("La petición esta prohibida sin una clave correcta");
  }
}
