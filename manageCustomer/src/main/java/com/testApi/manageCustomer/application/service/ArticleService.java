package com.testApi.manageCustomer.application.service;

import com.testApi.manageCustomer.application.contracts.IArticleService;
import com.testApi.manageCustomer.application.dtos.ArticleDto;
import com.testApi.manageCustomer.infraestructure.contracts.IArticleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauro
 */
@Service
public class ArticleService implements IArticleService{

     @Qualifier("article")
    private final IArticleRepository articleRepository;

    public ArticleService(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
     
     
    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
       
    }

    @Override
    public ArticleDto findById(Long id) {
       return articleRepository.findById(id);
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleRepository.save(articleDto);
    }

    @Override
    public ArticleDto update(Long id, ArticleDto articleDto) {
       return articleRepository.update(id, articleDto);
    }

    @Override
    public void deleteById(Long id) {
       articleRepository.deleteById(id);
    }
    
}
