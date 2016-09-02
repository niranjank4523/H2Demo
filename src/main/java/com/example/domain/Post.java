package com.example.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by niranjan on 29/8/16.
 */

@Entity
@NamedQuery(name = "Post.findByExactTitle", query = "select p from Post p where p.title = :title")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(columnDefinition = "text")
    private String body;

    @Column(columnDefinition = "TIMESTAMP")
    private Date postedOn;
    //Author
    @ManyToOne
    private Author author;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "reader_id", referencedColumnName = "id"))
    private List<PostReader> postReaderList = new ArrayList<PostReader>();

    @OneToOne
    private PostDetails postDetails;

    @SuppressWarnings("unused")
    private Post() {

    }

    public Post(String title) {
        this.setTitle(title);
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

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<PostReader> getPostReaderList() {
        return postReaderList;
    }

    public void setPostReaderList(List<PostReader> postReaderList) {
        this.postReaderList = postReaderList;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }
}
