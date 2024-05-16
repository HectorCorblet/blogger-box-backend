package com.dauphine.blogger.services;

import com.dauphine.blogger.Repository.PostRepository;
import com.dauphine.blogger.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements  PostService{

    private final PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return postRepository.findAllById(categoryId);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(UUID id) {
        return postRepository.findById(id).orElse(null);
    }


    @Override
    public Post create(String title, String content, UUID categoryID) {
        Post post = new Post();
        return postRepository.save(post);
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if (post == null) {
            return null;
        }
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    @Override
    public boolean deleteById(UUID id) {
        postRepository.deleteById(id);
        return true;
    }
    @Override
    public List<Post> getByTitleOrContent(String title, String content){
        return postRepository.findByTitleOrContent(title,content);
    }
}
