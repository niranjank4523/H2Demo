package com.example.command;

/**
 * Created by niranjan on 4/9/16.
 */
public class PostCO {
    private String authorFirstName;
    private String authorLastName;
    private String postTitle;
    private String postBody;
    private String postUrl;
    private Long postLength;

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public Long getPostLength() {
        return postLength;
    }

    public void setPostLength(Long postLength) {
        this.postLength = postLength;
    }
}
