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
* Nombre de archivo: ForbiddenException.java
* Autor: salvgonz
* Fecha de creación: 16 sep. 2021
*/

package com.tis.mx.application.controller.exception;

/**
 * The Class ForbiddenException.
 */
public class ForbiddenException extends RuntimeException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -4346653933748336588L;


  /**
   * Instantiates a new forbidden exception.
   *
   * @param message the message
   */
  public ForbiddenException(String message) {
    super(message);
  }
}
