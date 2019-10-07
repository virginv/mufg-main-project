package com.sample.api;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.api.model.Insurance;
import com.sample.api.service.InsuranceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleModelTests {

  @Autowired
  private InsuranceService service;

  @Test
  public void test_model_integrity(){

    List<Insurance> lst = service.findAll();
    Assert.assertEquals(6, lst.size());
    
  }

}

