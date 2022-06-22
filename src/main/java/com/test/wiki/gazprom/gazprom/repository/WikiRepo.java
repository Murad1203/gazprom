package com.test.wiki.gazprom.gazprom.repository;

import com.test.wiki.gazprom.gazprom.domain.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepo extends JpaRepository<Wiki, Integer> {
}
