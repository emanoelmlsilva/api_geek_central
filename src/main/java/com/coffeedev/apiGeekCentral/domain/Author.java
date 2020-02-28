package com.coffeedev.apiGeekCentral.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data()
@ToString(exclude = { "" })
@EqualsAndHashCode(of = {"id"})
@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Author(){}

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
