package com.dauphine.blogger.services;

import com.dauphine.blogger.Repository.CategoryRepository;
import com.dauphine.blogger.Repository.PostRepository;
import com.dauphine.blogger.dto.PostDto;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements  PostService{

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;


    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return postRepository.findAllByCategoryId(categoryId);
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
    public Post create(PostDto postDto) {
        Post post=new Post();
        post.setId(UUID.randomUUID());
        post.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        post.setCategory(categoryRepository.findById(postDto.getCategoryId()).orElse(null));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return postRepository.save(post);
    }

    @Override
    public Post update(UUID id, PostDto postDto) {
        Post post=getById(id);
        if(post==null){
            return null;
        }
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        Category category=categoryRepository.findById(id).orElse(null);
        post.setCategory(category);
        return postRepository.save(post);
    }

    @Override
    public boolean deleteById(UUID id) {
        postRepository.deleteById(id);
        return true;
    }
    @Override
    public List<Post> getByTitleOrContent(String value){
        return postRepository.findAllByTitleOrContentContainingValue(value);
    }
}
