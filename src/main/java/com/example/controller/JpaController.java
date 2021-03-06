package com.example.controller;

import com.example.command.PostCO;
import com.example.domain.Post;
import com.example.dto.PostDTO;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niranjan on 29/8/16.
 */
@RestController
public class JpaController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public PostDTO create(@RequestBody PostCO postCO) {
        return new PostDTO(postService.createPost(postCO));
    }

    @RequestMapping(value = "/getLatestPost",method = RequestMethod.GET)
    public PostDTO getLatestPost() {
        return new PostDTO(postService.getLatestPost());
    }

    @RequestMapping(value = "/getPostByQuery/{title}")
    public List<PostDTO> getPostByTitleQuery(@PathVariable String title) {
        List<Post> posts = postService.getPostByTitleQuery(title);
        List<PostDTO> postDTOs = new ArrayList<PostDTO>();
        for (Post post: posts) {
            postDTOs.add(new PostDTO(post));
        }
        return postDTOs;
    }

    @RequestMapping(value = "/getPostByNamedQuery/{title}")
    public List<PostDTO> getPostByExactTitleNamedQuery(@PathVariable String title) {
        List<Post> posts = postService.getPostByExactTitleNamedQuery(title);
        List<PostDTO> postDTOs = new ArrayList<PostDTO>();
        for (Post post: posts) {
            postDTOs.add(new PostDTO(post));
        }
        return postDTOs;
    }

    @RequestMapping(value = "/getPostByPage")
    public List<PostDTO> getPostByPage() {
        List<Post> posts = postService.getPostByPage();
        List<PostDTO> postDTOs = new ArrayList<PostDTO>();
        for (Post post: posts) {
            postDTOs.add(new PostDTO(post));
        }
        return postDTOs;
    }


    @RequestMapping(value = "/update")
    public PostDTO updateLatestPost() {
        return new PostDTO(postService.updatePost());
    }

    @RequestMapping(value = "/delete")
    public void deleteLatestPost() {
        postService.deletePost();
    }
}
