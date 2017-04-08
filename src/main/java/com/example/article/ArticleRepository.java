package com.example.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EOM on 2017-04-08.
 */
@Repository
public class ArticleRepository {
    //private Map<Long, Article> articles = new HashMap<>(); // map 은 Heap 메모리에 저장됨.

    @Autowired
    DataSource dataSource;

    public void add(Article article) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        String sql = "INSERT INTO ARTICLE(ID, TITLE, AUTHOR, BODY, CREATED) ";
        sql += "VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                article.getId(),
                article.getTitle(),
                article.getAuthor(),
                article.getBody(),
                //article.getCreated()
                new Date(article.getCreated().toInstant().toEpochMilli())
        });
        //articles.put(article.getId(), article);

    }

    public Article get(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        String sql = "SELECT * FROM ARTICLE WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Article>() {
            @Override
            public Article mapRow(ResultSet rs, int i) throws SQLException {
                Article article = new Article();
                article.setId(rs.getLong("ID"));
                article.setAuthor(rs.getString("AUTHOR"));
                article.setTitle(rs.getString("TITLE"));
                article.setBody(rs.getString("BODY"));
                article.setCreated(OffsetDateTime.now());
                return article;
            }

    });
    }

}
