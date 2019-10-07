package com.sample.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sample.api.model.Insurance;

/**
 * @author vleon
 *
 */
@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long>{

}
