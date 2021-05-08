package bogu.spring.productmanagement2.entities;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer")
public class ManufacturerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;

    @ManyToOne
    private ManufacturerModel manufacturer;

    public ManufacturerModel getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerModel manufacturer) {
        this.manufacturer = manufacturer;
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
