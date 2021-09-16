/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: BaseLineServiceRepository.java
* Autor: salvgonz
* Fecha de creación: 16 sep. 2021
*/

package com.tis.mx.application.repository;

import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import java.util.List;
import java.util.Map;
import feign.HeaderMap;
import feign.RequestLine;

/**
 * The Interface BaseLineServiceRepository.
 */
public interface BaseLineServiceRepository {

  /**
   * Post calculator ci.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return the list
   */
  @RequestLine("POST /api/v1/investors/calculators/ci")
  List<InvestmentYieldDto> postCalculatorCi(
      @HeaderMap Map<String,String> headers, InitialInvestmentDto initialInvestmentDto);
}
