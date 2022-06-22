package com.test.wiki.gazprom.gazprom.controller;

import com.test.wiki.gazprom.gazprom.domain.Wiki;
import com.test.wiki.gazprom.gazprom.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class WikController {

    @Autowired
    private WikiService wikiService;


    @GetMapping("/wiki/{title}")
    public List<Wiki> searchWiki(@PathVariable String title) throws IOException {

        List<Wiki> wiki = wikiService.getWiki(title);
        wikiService.saveWiki(wiki.get(0));
        return wiki;
    }

    @GetMapping("/all")
    public List<Wiki> getAllWiki() {
        return wikiService.getAllWikis();
    }

    @PostMapping("/update")
    public Wiki update(@RequestBody Wiki wiki) {
        wikiService.saveWiki(wiki);
        return wiki;
    }

}
