package com.testApi.manageCustomer.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testApi.manageCustomer.infraestructure.models.Article;


/**
 *
 * @author mauro
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}