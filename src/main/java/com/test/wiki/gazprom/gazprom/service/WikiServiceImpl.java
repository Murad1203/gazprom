package com.test.wiki.gazprom.gazprom.service;

import com.test.wiki.gazprom.gazprom.repository.WikiRepo;
import com.test.wiki.gazprom.gazprom.domain.Wiki;
import com.test.wiki.gazprom.gazprom.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WikiServiceImpl implements WikiService {

    @Autowired
    private WikiRepo wikiRepo;

    @Autowired
    private Parser parser;


    @Override
    public List<Wiki> getAllWikis() {
        return wikiRepo.findAll();
    }

    @Override
    public List<Wiki> getWiki(String title) throws IOException {
        List<Wiki> wiki = parser.parse(title);
//        wikiRepo.save((Wiki) wiki);

        return wiki;
    }

    @Override
    public void saveWiki(Wiki wiki) {
        wikiRepo.save(wiki);
    }


}
