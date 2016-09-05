package com.example.dto;

import com.example.domain.Post;

/**
 * Created by niranjan on 2/9/16.
 */
public class PostDTO {

    private Long id;
    private String title;
    private String body;
    private String postedOn;
    private AuthorDTO authorDTO;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
        if (post.getCreatedDate() != null)
            this.postedOn = post.getCreatedDate().toString();
        this.authorDTO = new AuthorDTO(post.getAuthor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

}
