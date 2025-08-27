package com.veterinary_clinic.veterinary_clinic.article.service;

import com.veterinary_clinic.veterinary_clinic.article.dto.ArticleDto;
import com.veterinary_clinic.veterinary_clinic.article.repository.ArticleRepository;
import com.veterinary_clinic.veterinary_clinic.procedures.dto.ProceduresDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    public List<ArticleDto> findAll(){
        return articleRepository.findAll().stream().map(article -> ArticleDto.builder()
                .id(article.getId())
                .name(article.getName())
                .text(article.getText())
                .description(article.getDescription())
                .image_path(article.getImage_path())
                .build()).toList();
    }
}
