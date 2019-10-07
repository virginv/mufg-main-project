package com.sample.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author vleon
 *
 */
@Entity
@ApiModel(description = "Insurance Detail")
public class Insurance {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank(message = "Name is mandatory")
  @ApiModelProperty(notes = "Name [mandatory field]")
  private String name;

  @Column(name= "numrequest")
  private int numRequest;

  @NotBlank(message = "Date is mandatory")
  @ApiModelProperty(notes = "Date [mandatory field]")
  private String date;

  @Column(name= "averageage")
  private int averageAge;

  private String campaign;

  public Insurance() {}
  
  public Insurance(Long id, String name, int numRequest, String date, int averageAge, String campaign) {
    this.id = id;
    this.name = name;
    this.numRequest = numRequest;
    this.date = date;
    this.averageAge = averageAge;
    this.campaign = campaign;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumRequest() {
    return numRequest;
  }

  public void setNumRequest(int numRequest) {
    this.numRequest = numRequest;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getAverageAge() {
    return averageAge;
  }

  public void setAverageAge(int averageAge) {
    this.averageAge = averageAge;
  }

  public String getCampaign() {
    return campaign;
  }

  public void setCampaign(String campaign) {
    this.campaign = campaign;
  }


}
