package com.chhaichivon.springbootrxjava.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author by chhai.chivon  on 10/4/2017.
 */
public interface BaseService<T> {
    Page<T> findAll(Pageable pageable);
    T findOne(Long id);
    T save(T entity);
    void update(T entity);
    void delete(T entity);
}
