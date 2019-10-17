package com.blackwell.main;

import com.blackwell.main.client.ArticlesJpaService;
import com.blackwell.main.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private ArticlesJpaService articlesJpaService;

    @ResponseBody
    @GetMapping("/")
    public Iterable<Article> main() {
        return this.articlesJpaService.findAll();
    }

}
