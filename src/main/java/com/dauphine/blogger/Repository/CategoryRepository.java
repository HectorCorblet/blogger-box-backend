package com.dauphine.blogger.Repository;

import com.dauphine.blogger.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("""
    select c
    from Category c
    where c.name like concat('%',:name,'%') 
    """)
    List<Category> findAllByName(@Param("name")String name);
    boolean existsByName(@Param("name")String name);

}
