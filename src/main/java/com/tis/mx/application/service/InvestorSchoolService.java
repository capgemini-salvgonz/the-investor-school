package com.tis.mx.application.service;

import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import java.util.List;

public interface InvestorSchoolService {

  List<InvestmentYieldDto> createSimulation(InitialInvestmentDto initialInvestment);
}
