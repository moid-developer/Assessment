package com.vd.repository;

import org.springframework.data.repository.CrudRepository;

import com.vd.bo.BookBO;

public interface BookStoreRepository extends CrudRepository<BookBO, Integer> {

}
