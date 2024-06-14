package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.PostDto;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.services.PostService;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.services.exceptions.PostNotFoundByIdException;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private PostService postService;



    public PostController(PostService postServiceService) {
        this.postService = postServiceService;
    }

    @PostMapping("")
    public Post createPost(@RequestBody PostDto postDto) {
        return postService.create(postDto);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable("postId") UUID postId,@RequestBody PostDto postDto) throws PostNotFoundByIdException {
        return postService.update(postId,postDto);

    }

    // Endpoint pour supprimer un post existant
    @DeleteMapping("/{postId}")
    public boolean deleteById(@PathVariable UUID postId) throws PostNotFoundByIdException {
        return postService.deleteById(postId);
    }

    @GetMapping("")
    public List<Post> getAll(){
        return postService.getAll();
    }

    @GetMapping("/{postId}")
    public Post getById(@PathVariable UUID postId) throws PostNotFoundByIdException {
        return postService.getById(postId);
    }

    @GetMapping("/categories/{categoryId}/posts")
    public List<Post> getAllByCategory(@PathVariable UUID categoryId) throws CategoryNotFoundByIdException {
        return postService.getAllByCategoryId(categoryId);
    }

    @GetMapping("/topics")
    public List<Post> getByTitleOrContent(@RequestParam String value){
        return postService.getByTitleOrContent(value);
    }


}
