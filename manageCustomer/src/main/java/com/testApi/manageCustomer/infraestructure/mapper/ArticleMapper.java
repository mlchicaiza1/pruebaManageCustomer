package com.testApi.manageCustomer.infraestructure.mapper;

import com.testApi.manageCustomer.application.dtos.ArticleDto;
import com.testApi.manageCustomer.infraestructure.models.Article;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mauro
 */
@Component
public class ArticleMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArticleDto mapEntityToDto(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }

    public Article mapDtoToEntity(ArticleDto articleDto) {
        return modelMapper.map(articleDto, Article.class);
    }
    
     public List<ArticleDto> mapEntitiesToDtos(List<Article> articles) {
        return articles.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public List<Article> mapDtosToEntities(List<ArticleDto> articleDtos) {
        return articleDtos.stream()
               .map(articleDto -> modelMapper.map(articleDto, Article.class))
                .collect(Collectors.toList());
    }
}