package com.blackwell.articles.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/article/")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable("id") long id) {
        Optional<Article> optional = this.articleRepository.findById(id);
        return optional.orElse(null); // if present return object, else null
    }

    @PostMapping
    public void save(Article article) {
        this.articleRepository.save(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.articleRepository.deleteById(id);
    }

}
