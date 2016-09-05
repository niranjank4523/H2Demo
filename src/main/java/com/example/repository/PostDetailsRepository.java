package com.example.repository;

import com.example.domain.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by niranjan on 4/9/16.
 */
public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {

}
