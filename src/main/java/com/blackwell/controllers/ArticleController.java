package com.blackwell.controllers;

import com.blackwell.beans.Article;

import com.blackwell.beans.Tag;
import com.blackwell.repository.ArticleRepository;
import com.blackwell.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping
@AllArgsConstructor
public class ArticleController {

    private static final String MAIN = "main-menu";
    private static final String REDIRECT_INDEX = "redirect:/article/";

    private static String UPLOADED_FOLDER = "\\resources\\images";

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
        modelAndView.addObject("art", articleRepository.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreateArticle() {
        return new ModelAndView("createarticle");
    }

    @PostMapping("/create")
    @ResponseBody
    public String processAJAXRequest(String title, String text, String[] tags, RedirectAttributes redirectAttributes) {
        Article art = new Article();
        art.setText(text);
        art.setTitle(title);
        art.setTags(Arrays.stream(tags)
                .map(Tag::new)
                .collect(Collectors.toList()));

        articleRepository.save(art);
        redirectAttributes.addFlashAttribute("id", art.getId());
        return String.format("%d", art.getId());
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public ResponseEntity<?> uploadFile(MultipartFile upload,HttpSession session, String id) {

        try {
            final String UPLOADED_PATH = session.getServletContext().getRealPath("/")
                    + UPLOADED_FOLDER + File.separator +  id + "." + FilenameUtils.getExtension(upload.getOriginalFilename());

            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(UPLOADED_PATH)));
            stream.write(upload.getBytes());
            stream.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
