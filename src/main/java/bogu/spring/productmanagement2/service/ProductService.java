package bogu.spring.productmanagement2.service;

import bogu.spring.productmanagement2.entities.ManufacturerModel;
import bogu.spring.productmanagement2.entities.ProductModel;
import bogu.spring.productmanagement2.repository.ManufacturerRepository;
import bogu.spring.productmanagement2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

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
        if (productModel.getPrice() > 0 && productModel.getName() != null) {
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

    public void addManufacturer(long idProduct, long idManufacturer) {

        Optional<ManufacturerModel> optionalManufacturerModel = manufacturerRepository.findById(idManufacturer);
        if (optionalManufacturerModel.isEmpty()) {
            throw new RuntimeException("Manufacturer doesn't exist!!!");
        }
        ManufacturerModel manufacturerModel = optionalManufacturerModel.get();

        Optional<ProductModel> optionalProductModel = productRepository.findById(idProduct);
        if (optionalProductModel.isEmpty()) {
            throw new RuntimeException("Product doesn't exist!!!");
        }
        ProductModel productModel = optionalProductModel.get();

        productModel.setManufacturer(manufacturerModel);
        productRepository.save(productModel);
    }
}
