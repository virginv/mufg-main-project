package com.sample.api.util;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.sample.api.enums.StatusResponse;

/**
 * @author vleon
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(description = "Operation Detail")
public class GenericResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(notes = "Operation StatusResponse")
  private StatusResponse status;

  @ApiModelProperty(notes = "Message")
  private String message;

  @ApiModelProperty(notes = "Operation Id")
  private Object id;

  public StatusResponse getStatus() {
    return status;
  }

  public void setStatus(StatusResponse status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getId() {
    return id;
  }

  public void setId(Object id) {
    this.id = id;
  }
}
