package com.testApi.manageCustomer.infraestructure.services;

import com.testApi.manageCustomer.application.dtos.ArticleDto;
import com.testApi.manageCustomer.infraestructure.contracts.IArticleRepository;
import com.testApi.manageCustomer.infraestructure.mapper.ArticleMapper;
import com.testApi.manageCustomer.infraestructure.models.Article;
import com.testApi.manageCustomer.infraestructure.repositories.ArticleRepository;
import com.testApi.manageCustomer.utils.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mauro
 */
@Repository("article")
public class JpaArticleService implements IArticleRepository{
    
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper; 

    public JpaArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }
    
        @Override
    public List<ArticleDto> findAll() {
       List<Article> articles = articleRepository.findAll();

       return articleMapper.mapEntitiesToDtos(articles);
    }


    @Override
    public ArticleDto findById(Long id) {
        
         Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id: " + id));
        return articleMapper.mapEntityToDto(article);
      
    }


    @Override
    public ArticleDto save(ArticleDto articleDto) {
     
        Article article = articleMapper.mapDtoToEntity(articleDto);
        
        Article articleClient = articleRepository.save(article);
        
        return articleMapper.mapEntityToDto(articleClient);
    }

    @Override
    public ArticleDto update(Long id, ArticleDto articleDto) {

         Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id: " + id));
        
        article.setCode(articleDto.getCode());
        article.setName(articleDto.getName());
        article.setPrice(articleDto.getPrice());

        
        Article updatedArticle = articleRepository.save(article);
        
        return articleMapper.mapEntityToDto(updatedArticle);
        
    }

    @Override
    public void deleteById(Long id) {
       
         Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id: " + id));
        
        articleRepository.delete(article);
        
    }
    
}
