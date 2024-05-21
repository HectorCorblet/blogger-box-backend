package com.dauphine.blogger.Repository;

import com.dauphine.blogger.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByCategoryId(UUID categoryId);
    @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE %:value% OR LOWER(p.content) LIKE %:value%")
    List<Post> findAllByTitleOrContentContainingValue(String value);
}
