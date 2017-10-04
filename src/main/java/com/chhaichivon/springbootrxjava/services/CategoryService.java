package com.chhaichivon.springbootrxjava.services;

import com.chhaichivon.springbootrxjava.helper.BaseService;
import com.chhaichivon.springbootrxjava.models.Category;
import com.chhaichivon.springbootrxjava.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author by chhai.chivon  on 10/4/2017.
 */
@Service
public class CategoryService  implements BaseService<Category> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void update(Category entity) {
         categoryRepository.save(entity);
    }

    @Override
    public void delete(Category entity) {
         categoryRepository.delete(entity);
    }
}
