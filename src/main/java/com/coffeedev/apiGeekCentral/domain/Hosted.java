package com.coffeedev.apiGeekCentral.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data()
@ToString(exclude = { "" })
@EqualsAndHashCode(of = {"id"})
@Entity
public class Hosted  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String type;

    @JsonIgnore
    @OneToOne(mappedBy = "hosted")
    private Manga manga;

    public Hosted(){}

    public Hosted(Long id, String url, String type) {
        this.id = id;
        this.url = url;
        this.type = type;
    }
}
