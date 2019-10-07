package com.sample.api.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import com.sample.api.model.Insurance;
import com.sample.api.service.impl.InsuranceServiceImpl;
import com.sample.api.util.GenericResponse;
import com.sample.api.util.ResponseUtil;

/**
 * @author vleon
 *
 */
@RestController
@RequestMapping("/api/v1/insurance")
@Api(value="/api/v1/insurance",produces="application/json",consumes="application/json")
public class SampleController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
  
  @Autowired 
  private InsuranceServiceImpl service;
  
  /**
   * Return all insurances
   * 
   * @return Insurance
   */
  @ApiOperation(value = "Return all insurances", response = List.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Operation succeeded"),
           				  @ApiResponse(code = 401, message = "Not authorized") })
  @GetMapping("/")
  public List<Insurance> getAll() throws Exception {
    LOGGER.info("GET ../insurance/ status=START");

    List<Insurance> insurances = service.findAll();

    LOGGER.info("GET ../insurance/ status=  END");
    return insurances;
  }
  
  /**
   * Get an insurance by id
   * 
   * @param id
   * @return insurance
   * @throws Exception 404, 500
   */
  @ApiOperation(value = "Get an insurance by id", response = ResponseEntity.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Operation succeeded"),
				          @ApiResponse(code = 401, message = "Not authorized"),
				          @ApiResponse(code = 404, message = "Not found") })
  @GetMapping("/{id}")
  public ResponseEntity<Insurance> getById(@PathVariable Long id) throws Exception {
      LOGGER.info("GET ../insurance/{} status=START", id);

      Insurance insurance = service.findById(id);

      LOGGER.info("GET ../insurance/{} status=  END", id);

      return ResponseUtil.wrapOrNotFound(Optional.ofNullable(insurance));
  }
  
  /**
   * Create an insurance
   * 
   * @param id
   * @return insurance
   * @throws Exception 404, 500
   */
  @ApiOperation(value = "Create an insurance", response = ResponseEntity.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Operation succeeded"),
				          @ApiResponse(code = 401, message = "Not authorized"),
				          @ApiResponse(code = 404, message = "Not found") })
  @PostMapping("/")
  public ResponseEntity<Insurance> create(@Valid @RequestBody Insurance insurance ) throws Exception {
      LOGGER.info("POST ../insurance/{} status= START");
      
      service.save(insurance);
      
      LOGGER.info("POST ../insurance/{} status= END");
      return ResponseUtil.wrapOrNotFound(Optional.ofNullable(insurance));
  }
  
  /**
   * Update an insurance
   * 
   * @param id
   * @return insurance
   * @throws Exception 404, 500
   */
  @ApiOperation(value = "Update an insurance", response = ResponseEntity.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Operation succeeded"),
				          @ApiResponse(code = 401, message = "Not authorized"),
				          @ApiResponse(code = 404, message = "Not found") })
  @PutMapping("/{id}")
  public ResponseEntity<GenericResponse> update(@PathVariable Long id, @Valid @RequestBody Insurance insurance ) throws Exception {
      LOGGER.info("PUT ../insurance/{} status= START", id);
      
      Boolean response = service.update(id, insurance);
      
      LOGGER.info("PUT ../insurance/{} status= END", id);
      return ResponseUtil.createResponse(response, id);
  }
  
  /**
   * Delete an insurance by id
   * 
   * @param id
   * @return insurance
   * @throws Exception 404, 500
   */
  @ApiOperation(value = "Delete an insurance by id", response = ResponseEntity.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Operation succeeded"),
				          @ApiResponse(code = 401, message = "Not authorized"),
				          @ApiResponse(code = 404, message = "Not found") })
  @DeleteMapping("/{id}")
  public ResponseEntity<GenericResponse> delete(@PathVariable Long id) throws Exception {
      LOGGER.info("DELETE ../insurance/{} status= START", id);
      
      Boolean response = service.delete(id);
      
      LOGGER.info("DELETE ../insurance/{} status= END", id);
      return ResponseUtil.createResponse(response, id);
  }


}
