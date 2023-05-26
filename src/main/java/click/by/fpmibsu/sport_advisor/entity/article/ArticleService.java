package click.by.fpmibsu.sport_advisor.entity.article;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log4j2
@Transactional
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ArticleService {
    ArticleRepository articleRepository;

    public Article save(Article article) {
        log.info("Save article: " + article);
        return articleRepository.save(article);
    }

    public List<Article> findByCategoryId(Long categoryId) {
        log.info("Find article by category id:" + categoryId);
        return articleRepository.findArticlesByCategory_Id(categoryId);
    }

    public Optional<Article> findById(Long id) {
        log.info("Find article by id:" + id);
        return articleRepository.findById(id);
    }
}
