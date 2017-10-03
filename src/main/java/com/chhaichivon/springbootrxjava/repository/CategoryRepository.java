package com.chhaichivon.springbootrxjava.repository;

import com.chhaichivon.springbootrxjava.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author by chhai.chivon  on 10/3/2017.
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
