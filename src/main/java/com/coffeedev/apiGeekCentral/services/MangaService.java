package com.coffeedev.apiGeekCentral.services;

import com.coffeedev.apiGeekCentral.domain.Manga;
import com.coffeedev.apiGeekCentral.repositories.Exception.ObjectNotFoundException;
import com.coffeedev.apiGeekCentral.repositories.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public List<Manga> findAll(){
        return mangaRepository.findAll();
    }

    public List<Manga> findTitle(String title){
        return mangaRepository.findByTitle(title);
    }

    public Manga findById(Integer id)throws ObjectNotFoundException {
        Optional<Manga> manga = mangaRepository.findById(id);
        return manga.orElseThrow(() -> new ObjectNotFoundException(
                "Manga não foi encontrado! Id: " + id + ", Tipo " + Manga.class.getName())
        );
    }

    public Manga insert(Manga manga){
        manga.setId(null);
        return mangaRepository.save(manga);
    }

    public Manga update(Manga manga) throws ObjectNotFoundException{
        Manga mangaNew = findById(manga.getId());
        updateData(mangaNew, manga);
        return mangaRepository.save(mangaNew);
    }

    public void removeById(Integer id) throws ObjectNotFoundException{
        mangaRepository.deleteById(id);
    }

    public void removeAll(){
        mangaRepository.deleteAll();
    }

    public List<Manga> orderByTitle(){
        List<Manga> mangas = mangaRepository.findAll();
        Comparator<Manga> compareByTitle = (Manga manga1, Manga manga2) -> manga1.getTitle().compareTo( manga2.getTitle() );
        Collections.sort(mangas,compareByTitle);
        return mangas;
    }

    public List<Manga> orderByNote(){
        List<Manga> mangas = mangaRepository.findAll();
        Comparator<Manga> compareByNote = (Manga manga1, Manga manga2) -> manga1.getPopular().getNote().compareTo(manga2.getPopular().getNote());
        Collections.sort(mangas,compareByNote);
        return mangas;
    }

    private void updateData(Manga mangaOld, Manga mangaNew){
        mangaNew.setTitle(mangaOld.getTitle());
        mangaNew.setChapterCurrent(mangaOld.getChapterCurrent());
        mangaNew.setChapterTotal(mangaOld.getChapterTotal());
        mangaNew.setNote(mangaOld.getNote());
        mangaNew.setFavorite(mangaOld.getFavorite());
        mangaNew.setCategories(mangaOld.getCategories());
        mangaNew.setAuthor(mangaOld.getAuthor());
        mangaNew.setPopular(mangaOld.getPopular());
        mangaNew.setHosted(mangaOld.getHosted());
    }
}
