package bogu.spring.productmanagement2.service;

import bogu.spring.productmanagement2.entities.ProductModel;
import bogu.spring.productmanagement2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    public void add(ProductModel productModel) {
        if (productModel.getPrice() < 1) {
            throw new RuntimeException("Product price should not be less than 1");
        }
        if (productModel.getName() == null) {
            throw new RuntimeException("Name is null!!! Please fill the name!");
        }
        productRepository.save(productModel);
    }

    public void edit(ProductModel productModel) {
        if (productModel.getPrice() > 0 &&
                productModel.getName() != null) {
            productRepository.save(productModel);
        }
    }

    public ProductModel getProductById(long id) {
        Optional<ProductModel> productModelOptional = productRepository.findById(id);
        ProductModel productModel = productModelOptional.get();
        return productModel;
    }

    public void removeById(long id) {
        productRepository.deleteById(id);
    }

    public List<ProductModel> getOrderedProducts() {
        List<ProductModel> orderedProducts = productRepository.getProductsOrderedByName();
        return orderedProducts;
    }
}
