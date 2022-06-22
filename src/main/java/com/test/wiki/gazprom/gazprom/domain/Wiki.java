package com.test.wiki.gazprom.gazprom.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Wiki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String create_timestamp;
    private String timestamp;
    private String language;
    private String wiki;

    private String category;
    private String title;
    private String auxiliary_text;


    public Wiki() {
    }

    public Wiki(String create_timestamp, String timestamp, String language, String wiki, String category, String title, String auxiliary_text) {
        this.create_timestamp = create_timestamp;
        this.timestamp = timestamp;
        this.language = language;
        this.wiki = wiki;
        this.category = category;
        this.title = title;
        this.auxiliary_text = auxiliary_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreate_timestamp() {
        return create_timestamp;
    }

    public void setCreate_timestamp(String create_timestamp) {
        this.create_timestamp = create_timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuxiliary_text() {
        return auxiliary_text;
    }

    public void setAuxiliary_text(String auxiliary_text) {
        this.auxiliary_text = auxiliary_text;
    }
}


