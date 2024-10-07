package com.testApi.manageCustomer.api.controllers;

import com.testApi.manageCustomer.application.dtos.ArticleDto;
import com.testApi.manageCustomer.application.service.ArticleService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mauro
 */

@RestController
@RequestMapping("/v1/api/article")
public class ArticleController {
    
    private final ArticleService service; 

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public List<ArticleDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> show(@PathVariable Long id) {
        ArticleDto articleDto = service.findById(id);
        return ResponseEntity.ok(articleDto);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDto create(@RequestBody ArticleDto articleDto) {
        return service.save(articleDto);
    }

    @PutMapping("/{id}")
    public ArticleDto update(@PathVariable Long id, @RequestBody ArticleDto articleDto) {

        return service.update(id,articleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArticleDto> delete(@PathVariable Long id) {       
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
