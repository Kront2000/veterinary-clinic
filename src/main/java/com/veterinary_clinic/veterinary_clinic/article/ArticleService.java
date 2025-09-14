package com.veterinary_clinic.veterinary_clinic.article;

import com.veterinary_clinic.veterinary_clinic.util.AddImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final AddImageService addImageService;
    public List<ArticleDto> findAll(){
        return articleRepository.findAll().stream().map(article -> ArticleDto.builder()
                .id(article.getId())
                .name(article.getName())
                .content(article.getContent())
                .description(article.getDescription())
                .image_path(article.getImage_path())
                .on_main(article.isOn_main())
                .build()).toList();
    }
    public Article save(ArticleDto articleDto) throws IOException {
        String image_path = addImageService.addImageCloudinary(articleDto.image());
        return articleRepository.save(Article.builder()
                        .name(articleDto.name())
                        .description(articleDto.description())
                        .image_path(image_path)
                        .content(articleDto.content())
                        .on_main(articleDto.on_main())
                .build());
    }
    public ArticleDto getById(Long id){
        Article article = articleRepository.findById(id).orElseThrow(RuntimeException::new);
        return ArticleDto.builder()
                .id(article.getId())
                .name(article.getName())
                .content(article.getContent())
                .description(article.getDescription())
                .image_path(article.getImage_path())
                .on_main(article.isOn_main())
                .build();
    }
    public Article update(ArticleDto articleDto) throws Exception {
        String image_path;
        if (articleDto.image() == null){
            image_path = articleRepository.findById(articleDto.id()).orElseThrow(Exception::new).getImage_path();
        }else{
            image_path = addImageService.addImageCloudinary(articleDto.image());
        }
        return articleRepository.save(Article.builder()
                .id(articleDto.id())
                .name(articleDto.name())
                .description(articleDto.description())
                .image_path(image_path)
                .content(articleDto.content())
                .on_main(articleDto.on_main())
                .build());
    }
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
