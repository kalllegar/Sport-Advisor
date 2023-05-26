package click.by.fpmibsu.sport_advisor.entity.article;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequestMapping("/api/v1/questions")
@RestController
@AllArgsConstructor
public class ArticleController {

    final ArticleService articleService;

    @GetMapping("byCategory/{id}")
    public List<Article> getArticlesByCategoryId(@PathVariable Long id) {
        log.info("Request method get articles by category id:" + id);
        return articleService.findByCategoryId(id);
    }

    @GetMapping("byId/{id}")
    public Optional<Article> getArticlesById(@PathVariable Long id) {
        log.info("Request method get articles by id: " + id);
        return articleService.findById(id);
    }
}
