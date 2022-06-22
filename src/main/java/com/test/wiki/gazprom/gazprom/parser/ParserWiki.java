package com.test.wiki.gazprom.gazprom.parser;

import com.test.wiki.gazprom.gazprom.domain.Wiki;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserWiki implements Parser {



    @Override
    public List<Wiki> parse(String url_stat) throws IOException {
        var wikis = new ArrayList<Wiki>();

        String title = "";
        String category = "";
        String create_timestamp = "";
        String timestamp = "";
        String language = "Russian";
        String wiki = "Wikipedia";
        String auxiliary_text = "Вспомогательная Информация";

        Document document = Jsoup.connect("https://ru.wikipedia.org/wiki/" + url_stat.toLowerCase()).get();

        Elements cat = document.getElementsByClass("mw-normal-catlinks");

        category = cat.get(0).getElementsByTag("li").text();


        //Парсинг Названия
        Element headFirst = document.getElementById("firstHeading");
        title = headFirst.text();

        //Парсинг текста
        Elements auxText = document.getElementsByClass("mw-parser-output");
        auxiliary_text = auxText.get(0).getElementsByTag("p").get(0).text();

        //Парсинг Даты статьи
        String url_info  = "https://ru.wikipedia.org/w/index.php?title="+ title + "&action=info";
        document = Jsoup.connect(url_info).get();


        Element time_create = document.getElementById("mw-pageinfo-firsttime");
        Elements td_create = time_create.select("td");
        create_timestamp = td_create.get(1).text();


        Element time_edit = document.getElementById("mw-pageinfo-lasttime");
        Elements td_edit = time_edit.select("td");
        timestamp = td_edit.get(1).text();


        if (!title.isEmpty() && !category.isEmpty() && !create_timestamp.isEmpty() && !timestamp.isEmpty() && !wiki.isEmpty() && !auxiliary_text.isEmpty()) {
            wikis.add(new Wiki(create_timestamp, timestamp,language, wiki, category, title, auxiliary_text));
        }

        return wikis;
    }
}
