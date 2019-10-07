package com.sample.api.enums;

/**
 * Differents kinds of errors
 * @author vleon
 *
 */
public enum ErrorCode {

  GENERIC_ERROR(1, "Undefined error"), 
  ERROR_CREATE(2, "Could not save item"),
  ERROR_NOT_FOUND(3, "Could not find item"),
  ERROR_UPDATE(4, "Could not update item"),
  ERROR_DELETE(5, "Could not delete item"),
  ERROR_DUPLICATE(6, "Item already exist"),
  ERROR_PARSING_OBJECT(7, "Could not parse item"),
  ERROR_VALIDATION(8, "Validation error");

  private int code;
  private String mensaje;

  private ErrorCode(int code, String mensaje) {
      this.code = code;
      this.mensaje = mensaje;
  }

  public int getCode() {
      return code;
  }

  public String getMensaje() {
      return mensaje;
  }
}
