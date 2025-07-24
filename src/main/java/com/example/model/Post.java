package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "標題不能為空")
    private String title;

    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @NotNull(message = "截止日期不能為空")
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @NotBlank(message = "公告者不能為空")
    private String author;

    @NotBlank(message = "公告內容不能為空")
    @Column(columnDefinition = "TEXT")
    private String content;

    // Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Date getPublishDate() { return publishDate; }

    public void setPublishDate(Date publishDate) { this.publishDate = publishDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}
