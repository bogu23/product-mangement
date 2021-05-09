package bogu.spring.productmanagement2.service;

import bogu.spring.productmanagement2.entities.CategoryModel;
import bogu.spring.productmanagement2.entities.ProductModel;
import bogu.spring.productmanagement2.repository.CategoryRepository;
import bogu.spring.productmanagement2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryModel);
    }

    public List<CategoryModel> getAll() {
        List<CategoryModel> categories = categoryRepository.findAll();
        return categories;
    }

    public void addProduct(long idProduct, long idCategory) {

        Optional<CategoryModel> categoryModelOptional = categoryRepository.findById(idCategory);
        if (categoryModelOptional.isEmpty()) {
            throw new RuntimeException("Category dosen't exist");
        }
        CategoryModel categoryModel = categoryModelOptional.get();

        Optional<ProductModel> productModelOptional = productRepository.findById(idProduct);
        if (productModelOptional.isEmpty()) {
            throw new RuntimeException("Product dosen't exist!");
        }
        ProductModel productModel = productModelOptional.get();

        List<ProductModel> productsFromCategory = categoryModel.getProducts();
        productsFromCategory.add(productModel);

        categoryRepository.save(categoryModel);
    }



}
