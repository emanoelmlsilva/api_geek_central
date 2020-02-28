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
public class Popular  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Double note;

    private Boolean favorite;

    @JsonIgnore
    @OneToOne(mappedBy = "popular")
    private Manga manga;

    public Popular(){}

    public Popular(Long id, Double note, Boolean favorite) {
        this.id = id;
        this.note = note;
        this.favorite = favorite;
    }
}
