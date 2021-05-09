package bogu.spring.productmanagement2.service;

import bogu.spring.productmanagement2.entities.CategoryModel;
import bogu.spring.productmanagement2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryModel);
    }

    public List<CategoryModel> getAll() {
        List<CategoryModel> categories = categoryRepository.findAll();
        return categories;
    }

}
