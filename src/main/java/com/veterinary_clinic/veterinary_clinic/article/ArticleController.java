package com.veterinary_clinic.veterinary_clinic.article;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PostMapping("/add")
    public void save(@RequestParam("name") String name,@RequestParam("description") String description, @RequestParam("on_main") boolean onMain,
                     @RequestParam("text") String text, @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        ArticleDto articleDto = ArticleDto.builder()
                .name(name)
                .description(description)
                .content(text)
                .image(image)
                .on_main(onMain)
                .build();
        articleService.save(articleDto);
    }
    @PostMapping("/edit")
    public void update(@RequestParam("name") String name,@RequestParam("description") String description, @RequestParam("on_main") boolean onMain,
                     @RequestParam("text") String text, @RequestPart(value = "image", required = false) MultipartFile image, @RequestParam("id") Long id) throws Exception {
        ArticleDto articleDto = ArticleDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .content(text)
                .image(image)
                .on_main(onMain)
                .build();
        articleService.update(articleDto);
    }
    @GetMapping("/getById")
    public ArticleDto getById(@RequestParam("id") Long id){
        return articleService.getById(id);
    }
}
