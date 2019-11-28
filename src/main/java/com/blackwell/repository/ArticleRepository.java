package com.blackwell.repository;

import com.blackwell.beans.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {


}
