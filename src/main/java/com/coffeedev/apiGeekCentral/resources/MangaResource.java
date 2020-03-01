package com.coffeedev.apiGeekCentral.resources;

import com.coffeedev.apiGeekCentral.domain.Manga;
import com.coffeedev.apiGeekCentral.repositories.Exception.ObjectNotFoundException;
import com.coffeedev.apiGeekCentral.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="v1/api/mangas")
public class MangaResource {

    @Autowired
    private MangaService mangaService;

    @GetMapping("")
    public ResponseEntity<List<Manga>> findAll(){
        List<Manga> mangas = mangaService.findAll();
        return ResponseEntity.ok().body(mangas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable(value = "id") Integer id) throws ObjectNotFoundException{
        Manga manga = mangaService.findById(id);
        return ResponseEntity.ok().body(manga);
    }

    @GetMapping("/titles")
    public ResponseEntity<List<Manga>> orderTitles(){
        List<Manga> mangas = mangaService.orderByTitle();
        return ResponseEntity.ok().body(mangas);
    }

    @GetMapping("/rankings")
    public ResponseEntity<List<Manga>> orderNote(){
        List<Manga> mangas = mangaService.orderByNote();
        return ResponseEntity.ok().body(mangas);
    }

    @PostMapping("")
    public ResponseEntity<Manga> insert(@RequestBody Manga manga){
        Manga mangaPost = mangaService.insert(manga);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mangaPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(value = "id") Integer id, @RequestBody Manga manga) throws ObjectNotFoundException{
        manga.setId(id);
        manga = mangaService.update(manga);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ObjectNotFoundException{
        mangaService.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteAll() throws ObjectNotFoundException{
        mangaService.removeAll();
        return ResponseEntity.noContent().build();
    }
}
