package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    @PostMapping("/")
    public String createNewPost(@RequestBody Post post){
        return "";
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable int id, @RequestBody Post post){
        return "";
    }

    // Endpoint pour supprimer un post existant
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id){
        return "";
    }

    @GetMapping("/")
    public List<Post> getAllPostsOrderedByCreationDate(){
        return null;
    }

    @GetMapping("/categories/{categoryId}")
    public List<Post> getPostsByCategory(@PathVariable int categoryId){
        return null;
    }

}
