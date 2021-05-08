package bogu.spring.productmanagement2.controller;

import bogu.spring.productmanagement2.entities.ProductModel;
import bogu.spring.productmanagement2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("getProducts")
    public List<ProductModel> getAllProducts() {
        List<ProductModel> productModelList = productRepository.findAll();
        return productModelList;
    }

    @PostMapping("addProducts")
    public void addProduct(@RequestBody ProductModel productToBeAdded) {
        productRepository.save(productToBeAdded);
    }

    @PutMapping("edit")
    public void editProduct(@RequestBody ProductModel productToBeEdited) {
        productRepository.save(productToBeEdited);

    }

    @GetMapping("getProductById/{id}")
    public ProductModel getProductById(@PathVariable long id) {
       Optional<ProductModel> foundProduct = productRepository.findById(id);
        return foundProduct.get();
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteProductById(@PathVariable long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("getOrderedProducts")
    public List<ProductModel> getProductsOrdered() {
        List<ProductModel> orderedProducts = productRepository.getProductsOrderedByName();
        return orderedProducts;
    }

}
