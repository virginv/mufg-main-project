package com.sample.api.service;

import java.util.List;

/**
 * @author vleon
 *
 */
public interface GlobalService<T> {
  
  List<T> findAll();
  T save(T t);
  Boolean update(Long id, T t);
  T findById(Long id);
  Boolean delete(Long id);

}
