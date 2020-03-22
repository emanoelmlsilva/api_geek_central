package com.coffeedev.apiGeekCentral.dtos;

import com.coffeedev.apiGeekCentral.domain.Manga;

import java.io.Serializable;

public class MangaBaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private Double chapterCurrent;

    private Double chapterTotal;

    private Double note;

    private Boolean favorite;

    public MangaBaseDTO(Manga manga){
        this.id = manga.getId();
        this.title = manga.getTitle();
        this.chapterCurrent = manga.getChapterCurrent();
        this.chapterTotal = manga.getChapterTotal();
        this.note = manga.getNote();
        this.favorite = manga.getFavorite();

    }
}
