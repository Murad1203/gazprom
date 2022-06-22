package com.test.wiki.gazprom.gazprom.service;

import com.test.wiki.gazprom.gazprom.domain.Wiki;

import java.io.IOException;
import java.util.List;

public interface WikiService {
    public List<Wiki> getAllWikis();
    public List<Wiki> getWiki(String title) throws IOException;
    public void saveWiki(Wiki wiki);
}
