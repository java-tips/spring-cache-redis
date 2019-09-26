package com.cache.redis;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Customer implements Serializable {
   
    private static final long serialVersionUID = -5334006640444795390L;

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


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }


}
   