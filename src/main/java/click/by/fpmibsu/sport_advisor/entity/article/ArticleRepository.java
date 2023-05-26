package click.by.fpmibsu.sport_advisor.entity.article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticlesByCategory_Id(Long categoryId);
}
