package com.example.repository;

import com.example.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by niranjan on 29/8/16.
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {

}
