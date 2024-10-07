package com.testApi.manageCustomer.infraestructure.contracts;

import com.testApi.manageCustomer.application.dtos.ArticleDto;
import java.util.List;

/**
 *
 * @author mauro
 */
public interface IArticleRepository {
    
    List<ArticleDto> findAll();
    
    ArticleDto findById(Long id);
        
    ArticleDto save(ArticleDto articleDto);
    
    ArticleDto update(Long id,ArticleDto articleDto);
    
    void deleteById(Long id);     
}
