package com.veterinary_clinic.veterinary_clinic.article.controller;

import com.veterinary_clinic.veterinary_clinic.article.dto.ArticleDto;
import com.veterinary_clinic.veterinary_clinic.article.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
@AllArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getAll(){
        log.info("Fetching all articles");
        return articleService.findAll();
    }
}
