package com.example.service;

import com.example.command.PostCO;
import com.example.domain.Author;
import com.example.domain.Post;
import com.example.domain.PostDetails;
import com.example.repository.AuthorRepository;
import com.example.repository.PostDetailsRepository;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    @Autowired
    private PostDetailsRepository postDetailsRepository;

    public Post createPost(PostCO postCO) {
        Author author = new Author(postCO.getAuthorFirstName(), postCO.getAuthorLastName());
        authorRepository.save(author);

        PostDetails postDetails = new PostDetails();
        postDetails.setUrl(postCO.getPostUrl());
        postDetails.setLength(postCO.getPostLength());
        postDetailsRepository.save(postDetails);

        Post post = new Post(postCO.getPostTitle());
        post.setAuthor(author);
        post.setPostDetails(postDetails);
        post.setBody(postCO.getPostBody());

        return postRepository.save(post);
    }

    public Post getLatestPost() {
        return postRepository.findFirstByOrderByCreatedDateDesc();
    }

    public List<Post> getPostByTitleQuery(String title) {
        return postRepository.findPostsWithGivenTitle(title);
    }

    public List<Post> getPostByExactTitleNamedQuery(String title) {
        return postRepository.findByExactTitle(title);
    }

    public List<Post> getPostByPage() {
        Pageable pageable = new PageRequest(0, 2, new Sort(Sort.Direction.DESC, "id"));
        Page<Post> postPage = postRepository.findAll(pageable);
        return postPage.getContent();
    }

    public Post updatePost() {
        Author author = new Author("Steve", "Jobs");
        authorRepository.save(author);

        Post post = postRepository.findFirstByOrderByCreatedDateDesc();
        post.setAuthor(author);

        return postRepository.save(post);
    }

    public void deletePost() {
        Post post = postRepository.findFirstByOrderByCreatedDateDesc();
        postRepository.delete(post);
    }
}
