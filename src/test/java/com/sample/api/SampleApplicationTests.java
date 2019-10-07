package com.sample.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sample.api.rest.SampleController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {

  private MockMvc mockMvc;

  @Autowired
  SampleController controller;

  @Test
  public void contextLoads() throws Exception {
      mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/insurance/")
                                                                  .contentType(MediaType.APPLICATION_JSON))
                                                                  .andReturn();

      Assert.assertEquals(200, mvcResult.getResponse().getStatus());

  }

}

