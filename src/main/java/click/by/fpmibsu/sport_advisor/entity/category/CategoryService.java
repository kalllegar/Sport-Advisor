package click.by.fpmibsu.sport_advisor.entity.category;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Transactional
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryService {
    CategoryRepository categoryRepository;

    public List<Category> findRoot(){
        log.info("Find all root categories");
        return categoryRepository.findByParentId(null);
    }

    public List<Category> findChildren(Long parentId){
        log.info("Find all categories by parent category id: " + parentId);
        return categoryRepository.findByParentId(parentId);
    }


}
