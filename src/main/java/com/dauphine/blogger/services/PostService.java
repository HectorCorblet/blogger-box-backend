package com.dauphine.blogger.services;

import com.dauphine.blogger.dto.PostDto;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.PostNotFoundByIdException;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllByCategoryId(UUID categoryId) throws CategoryNotFoundByIdException;

    List<Post> getAll();
    Post getById(UUID id)throws PostNotFoundByIdException;

    Post create(PostDto postDto);
    Post update(UUID id,PostDto postDto)throws PostNotFoundByIdException;

    boolean deleteById(UUID id)throws PostNotFoundByIdException;
    List<Post> getByTitleOrContent(String value);
}
