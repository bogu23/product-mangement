package bogu.spring.productmanagement2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manufacturer")
public class ManufacturerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "manufacturer")
    private List<ProductModel> productsModel = new ArrayList<>();

    public List<ProductModel> getProductModel() {
        return productsModel;
    }

    public void setProductModel(List<ProductModel> productModel) {
        this.productsModel = productModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
