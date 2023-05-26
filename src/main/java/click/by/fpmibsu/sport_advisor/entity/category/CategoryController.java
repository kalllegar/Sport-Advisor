package click.by.fpmibsu.sport_advisor.entity.category;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/categories")
@RestController
@AllArgsConstructor
@Slf4j
public class CategoryController {

    final CategoryService categoryService;

    @GetMapping
    public List<Category> getRootCategories() {
        log.info("Request method get root categories");
        return categoryService.findRoot();
    }

    @GetMapping("{id}")
    public List<Category> getChildrenCategories(@PathVariable Long id) {
        log.info("Request method get children categories: " + id);
        return categoryService.findChildren(id);
    }
}
