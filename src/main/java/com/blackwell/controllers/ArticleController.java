package com.blackwell.controllers;

import com.blackwell.beans.Article;
import com.blackwell.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@AllArgsConstructor
public class ArticleController {

    private static final String MAIN = "main-menu";
    private static final String REDIRECT_INDEX = "redirect:/article/";

    private ArticleRepository articleRepository;

    @GetMapping("/")
    public ModelAndView getArticles() {
        ModelAndView modelAndView = new ModelAndView(MAIN);
        modelAndView.addObject("articles", articleRepository.findAll());
        return modelAndView;
    }


    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("article");
        modelAndView.addObject("art", articleRepository.findById(id).get() );
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreateArticle() {
        return new ModelAndView("createarticle");
    }


    @PostMapping("/create")
    public ModelAndView createArticle(String title, String text) {
        Article art = new Article();
        art.setText(text);
        art.setTitle(title);
        articleRepository.save(art);
        return new ModelAndView(MAIN);
    }


}
