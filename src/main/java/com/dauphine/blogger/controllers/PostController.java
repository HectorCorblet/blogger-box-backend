package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.services.PostService;
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

    @PostMapping("/")
    public Post create(@RequestBody String title, @RequestBody String content, @PathVariable UUID categoryId){
        return postService.create(title,content,categoryId);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable UUID id, @RequestBody String title,@RequestBody String content ){
        return postService.update(id,title,content);
    }

    // Endpoint pour supprimer un post existant
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable UUID id){
        return postService.deleteById(id);
    }

    @GetMapping("/")
    public List<Post> getAll(){
        return postService.getAll();
    }

    @GetMapping("/{postId}")
    public Post getById(@PathVariable UUID id){
        return postService.getById(id);
    }

    @GetMapping("/categories/{categoryId}")
    public List<Post> getAllByCategory(@PathVariable UUID categoryID){
        return postService.getAllByCategoryId(categoryID);
    }

    @GetMapping("/topics")
    public List<Post> getByTitleOrContent(@RequestParam String title, @RequestParam String content){
        return postService.getByTitleOrContent(title,content);
    }


}
