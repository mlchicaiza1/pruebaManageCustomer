package com.testApi.manageCustomer.application.dtos;


/**
 *
 * @author mauro
 */
public class ArticleDto {
    
    private Long id;
    private String code;
    private String name;
    private Double price;
    
    public ArticleDto() {
    }

    public ArticleDto(Long id, String code, String name, Double price ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

