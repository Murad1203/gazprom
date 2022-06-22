package com.test.wiki.gazprom.gazprom.parser;

import com.test.wiki.gazprom.gazprom.domain.Wiki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Parser {
    List<Wiki> parse(String url_stat) throws IOException;
}
