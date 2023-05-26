package click.by.fpmibsu.sport_advisor.entity.category;

import click.by.fpmibsu.sport_advisor.entity.article.Article;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "parent_id")
        private Category parent;
        private String name;
        @JsonIgnore
        @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
        private List<Category> children;
        @JsonIgnore
        @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
        private List<Article> articles;

        @Builder.Default
        LocalDateTime createdAt = LocalDateTime.now();
}
