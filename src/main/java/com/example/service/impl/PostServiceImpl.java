package com.example.service.impl;

import com.example.dao.PostDao;
import com.example.dao.PostDaoImpl;
import com.example.model.Post;
import com.example.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    private PostDao postDao = new PostDaoImpl(); // 實作綁定

    @Override
    public void save(Post post) {
        postDao.save(post);
    }

    @Override
    public void update(Post post) {
        postDao.update(post);
    }

    @Override
    public void delete(int id) {
        postDao.delete(id);
    }

    @Override
    public Post findById(int id) {
        return postDao.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }
}
