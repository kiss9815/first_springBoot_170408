package com.example.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EOM on 2017-04-08.
 */

@Service
public class ArticleService {

    @Autowired ArticleRepository repository;// = new ArticleRepository();

    public Article createArticle(ArticleCreateRequest request){


        Article article = new Article(request.getId(),
                            request.getTitle(),
                            request.getAuthor(),
                            request.getBody()
        );

        repository.add(article);

        return article;
    }

    public Article getArticle(long articleId) {


        return repository.get(articleId);
    }
}
