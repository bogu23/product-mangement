package bogu.spring.productmanagement2.controller;

import bogu.spring.productmanagement2.entities.CategoryModel;
import bogu.spring.productmanagement2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("addCategory")
    public void addCategory(@RequestBody CategoryModel categoryModel) {
        categoryService.addCategory(categoryModel);
    }

    @GetMapping("getCategories")
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    @PutMapping("addProductToCategory/{idProduct}/{idCategory}")
    public void addProductToCategory(@PathVariable long idProduct, @PathVariable long idCategory) {
        categoryService.addProduct(idProduct, idCategory);

    }
}
