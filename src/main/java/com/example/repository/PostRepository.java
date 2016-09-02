package com.example.repository;

import com.example.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by niranjan on 29/8/16.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    //Dynamic Finder
    Post findFirstByOrderByPostedOnDesc();


    //Using Query annotation
    @Query(value = "select p from Post p where p.title like %:title%", nativeQuery = false)
    //@Query(value = "select p from Post p where p.title like '%?1%'", nativeQuery = false)
    List<Post> findPostsWithGivenTitle(@Param("title") String title);


    //Named Query
    List<Post> findByExactTitle(@Param("title") String title);

}
