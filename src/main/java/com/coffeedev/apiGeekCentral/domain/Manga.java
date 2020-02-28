package com.coffeedev.apiGeekCentral.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data()
@ToString(exclude = { "" })
@EqualsAndHashCode(of = {"id"})
@Entity
public class Manga  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double chapterCurrent;

    private Double chapterTotal;

    private Double note;

    private Boolean favorite;

    @ElementCollection
    @CollectionTable(name="categories", joinColumns = @JoinColumn(name = "categories_id"))
    private List<String> categories;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manga_author")
    private Author author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manga_popular")
    private Popular popular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manga_hosted")
    private Hosted hosted;

    public Manga(){}

    public Manga(Long id, String title, Double chapterCurrent, Double chapterTotal, Double note, Boolean favorite, List<String> categories, Author author, Popular popular, Hosted hosted) {
        this.id = id;
        this.title = title;
        this.chapterCurrent = chapterCurrent;
        this.chapterTotal = chapterTotal;
        this.note = note;
        this.favorite = favorite;
        this.categories = categories;
        this.author = author;
        this.popular = popular;
        this.hosted = hosted;
    }
}
