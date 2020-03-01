package com.coffeedev.apiGeekCentral.services;

import com.coffeedev.apiGeekCentral.domain.Author;
import com.coffeedev.apiGeekCentral.domain.Hosted;
import com.coffeedev.apiGeekCentral.domain.Manga;
import com.coffeedev.apiGeekCentral.domain.Popular;
import com.coffeedev.apiGeekCentral.repositories.AuthorRepository;
import com.coffeedev.apiGeekCentral.repositories.HostedRepository;
import com.coffeedev.apiGeekCentral.repositories.MangaRepository;
import com.coffeedev.apiGeekCentral.repositories.PopularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BDService {

    @Autowired
    private MangaRepository mangarepository;

    @Autowired
    private AuthorRepository authorrepository;

    @Autowired
    private HostedRepository hostedrepository;

    @Autowired
    private PopularRepository popularrepository;

    public void instantiateTestDatabase() throws ParseException {

        Author author1 = new Author(null,"authorOnePiece");
        Author author2 = new Author(null,"authorKingdom");

        Hosted hosted1 = new Hosted(null,"link","tipo sé é site ou alguma coisa");
        Hosted hosted2 = new Hosted(null,"link2","tipo sé é site ou alguma coisa2222");

        Popular p1 = new Popular(null, 5.0,true);
        Popular p2 = new Popular(null, 4.7, false);

        List<String> lista1 = new ArrayList();
        lista1.add("shounin");

        List<String> lista2 = new ArrayList();
        lista2.add("não sei");

		Manga literayWork1 = new Manga(null,"One Piece",918.0,918.0,5.0,true,lista1,author1, p1, hosted1);
		literayWork1.setAuthor(author1);
        Manga literayWork2 = new Manga(null,"Kingdom",628.0,628.0,4.9,true,lista2,null, p2, hosted2);
		literayWork2.setAuthor(author2);
		mangarepository.saveAll(Arrays.asList(literayWork1,literayWork2));

		author1.getMangas().addAll(Arrays.asList(literayWork1));
		author2.getMangas().addAll(Arrays.asList(literayWork2));

        authorrepository.saveAll(Arrays.asList(author1,author2));

        popularrepository.saveAll(Arrays.asList(p1,p2));
        hostedrepository.saveAll(Arrays.asList(hosted1,hosted2));

    }
}
