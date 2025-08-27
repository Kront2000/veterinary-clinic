package com.veterinary_clinic.veterinary_clinic.article.repository;

import com.veterinary_clinic.veterinary_clinic.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
