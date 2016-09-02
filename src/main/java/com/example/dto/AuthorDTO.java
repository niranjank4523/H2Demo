package com.example.dto;

import com.example.domain.Author;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by niranjan on 2/9/16.
 */
public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
