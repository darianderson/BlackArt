package com.blackwell.main.client;

import com.blackwell.main.domain.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ARTICLES-JPA-SERVICE")
public interface ArticlesJpaService {

    @GetMapping("/article/")
    Iterable<Article> findAll();

}
