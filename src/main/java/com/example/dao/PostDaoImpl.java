package com.example.dao;

import com.example.model.Post;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PostDaoImpl implements PostDao {

    @Override
    public void save(Post post) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Post post) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(post);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Post post = session.get(Post.class, id);
        if (post != null) {
            session.delete(post);
        }
        tx.commit();
        session.close();
    }

    @Override
    public Post findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

    @Override
    public List<Post> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Post> query = session.createQuery("FROM Post", Post.class);
        List<Post> posts = query.list();
        session.close();
        return posts;
    }
}
