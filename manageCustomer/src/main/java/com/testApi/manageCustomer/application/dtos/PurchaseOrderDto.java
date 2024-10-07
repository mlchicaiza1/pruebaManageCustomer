package com.testApi.manageCustomer.application.dtos;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mauro
 */
public class PurchaseOrderDto {

    private Long id;
    private String code;
    private LocalDate date;
    private ClientDto client;
    private List<ArticleDto> articles;

    public PurchaseOrderDto() {
    }


    public PurchaseOrderDto(Long id, String code, LocalDate date, ClientDto client,List<ArticleDto> articles) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.client = client;
        this.articles = articles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDto> articles) {
        this.articles = articles;
    }
}
