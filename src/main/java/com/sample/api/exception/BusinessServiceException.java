package com.sample.api.exception;

import com.sample.api.enums.ErrorCode;

/**
 * Customized exception
 * @author vleon
 *
 */
public class BusinessServiceException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final ErrorCode code;
  private final String    mensaje;

  public BusinessServiceException(ErrorCode code) {
      super(code.getMensaje());
      this.code    = code;
      this.mensaje = code.getMensaje();
  }

  public BusinessServiceException(ErrorCode code, String mensaje) {
      super(code.getMensaje());
      this.code    = code;
      this.mensaje = mensaje;
  }

  public BusinessServiceException(String mensaje) {
      super();
      this.code    = ErrorCode.GENERIC_ERROR;
      this.mensaje = mensaje;
  }

  public ErrorCode getCode() {
      return code;
  }

  public String getMensaje() {
      return mensaje;
  }
}
