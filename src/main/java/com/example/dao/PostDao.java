package com.example.dao;

import com.example.model.Post;
import java.util.List;

public interface PostDao {
    void save(Post post);
    void update(Post post);
    void delete(int id);
    Post findById(int id);
    List<Post> findAll();
}
