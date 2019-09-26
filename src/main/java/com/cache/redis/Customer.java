package com.cache.redis;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    private Long id;
    private String name;

    public Customer() {
    }

    public Customer(String name, Long id) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
   