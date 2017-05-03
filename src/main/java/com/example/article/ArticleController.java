package com.example.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created by EOM on 2017-04-08.
 */
@Controller
public class ArticleController {



    @Autowired ArticleService service;

    @PostConstruct
    public void setDummyArticle(){
        service.createArticle(
                new ArticleCreateRequest(1L, "제목이다","준태","내용이다")
        );
    }

    //ctrl p


    //@RequestMapping(value="/article/{articleId}", method = RequestMethod.GET)
    @GetMapping("/article/{articleId}")
    public String getArticle(Model model, @PathVariable Long articleId){

        Article article = service.getArticle(articleId);

        model.addAttribute("article", article);

        return "article";
    }


    //@RequestMapping(value="/article", method = RequestMethod.POST)
    @PostMapping("/article")
    public String createArticle(@ModelAttribute ArticleCreateRequest request){


        service.createArticle(request);

        //System.out.println(request.toString());

        return "redirect:/article/" + request.getId();
    }


    @RequestMapping("/article/create")
    public String createArticleView(){


        return "createArticle";
    }

}
