
package com.example.demo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private final String shareUuid = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getShareUuid() { return shareUuid; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
