package com.sample.api.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.api.exception.NotFoundException;
import com.sample.api.model.Insurance;
import com.sample.api.repository.InsuranceRepository;
import com.sample.api.service.InsuranceService;

/**
 * @author vleon
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

  private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceServiceImpl.class);

  @Autowired
  private InsuranceRepository repository;
  
  @Override
  public List<Insurance> findAll() {
    LOGGER.info("getAll status= START");
    List<Insurance> results = (List<Insurance>) repository.findAll();
    LOGGER.info("getAll status= END");
    return results;
  }
  
  @Override
  public Insurance findById(Long id) {
    LOGGER.info("findById status= START id: {}", id);
    Insurance result = repository.findById(id)
    		 .orElseThrow(() -> new NotFoundException("Invalid Id:" + id));
    LOGGER.info("findById status= END");
    return result;  
  }
  
  @Override
  public Insurance save(Insurance t) {
	LOGGER.info("save status= START");
	t = repository.save(t);
	LOGGER.info("save status= END");
	return t;
  }

  @Override
  public Boolean update(Long id, Insurance t) {
	LOGGER.info("update status= START id: {}", id);
	Insurance insurance = repository.findById(id)
      .orElseThrow(() -> new NotFoundException("Invalid Id:" + t.getId()));
	insurance.setName(t.getName());
	insurance.setCampaign(t.getCampaign());
	insurance.setNumRequest(t.getNumRequest());
	insurance.setAverageAge(t.getAverageAge());
    repository.save(insurance);
    LOGGER.info("update status= END id: {}", id);
    return true;
  }

  @Override
  public Boolean delete(Long id) {
	LOGGER.info("delete status= START id: {}", id);
    repository.findById(id)
    	      .orElseThrow(() -> new NotFoundException("Invalid Id:" + id));
    repository.deleteById(id);
    LOGGER.info("delete status= END id: {}", id);
    return true;
  }

}
