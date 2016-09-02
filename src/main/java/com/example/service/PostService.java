package com.example.service;

import com.example.domain.Author;
import com.example.domain.Post;
import com.example.repository.AuthorRepository;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by niranjan on 29/8/16.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;


    public Post createPost() {
        //Using basic CRUD implementation
        Author author = new Author("Bill", "Gates");
        authorRepository.save(author);

        Post post = new Post("Dummy Post title");
        post.setAuthor(author);
        post.setPostedOn(new Date());
        post.setBody("Here goes the Body for the Dummy Post!!!");
        return postRepository.save(post);
    }

    public Post getLatestPost() {
        return postRepository.findFirstByOrderByPostedOnDesc();
    }

    public List<Post> getPostByTitleQuery(String title) {
        return postRepository.findPostsWithGivenTitle(title);
    }

    public List<Post> getPostByExactTitleNamedQuery(String title) {
        return postRepository.findByExactTitle(title);
    }

    public List<Post> getPostByPage() {
        Pageable pageable = new PageRequest(0,2,new Sort(Sort.Direction.DESC,"id"));
        Page<Post> postPage = postRepository.findAll(pageable);
        return postPage.getContent();
    }

    public Post updatePost() {
        Author author = new Author("Steve", "Jobs");
        authorRepository.save(author);

        Post post = postRepository.findFirstByOrderByPostedOnDesc();
        post.setAuthor(author);

        return postRepository.save(post);
    }

    public void deletePost() {
        Post post = postRepository.findFirstByOrderByPostedOnDesc();
        postRepository.delete(post);
    }
}
