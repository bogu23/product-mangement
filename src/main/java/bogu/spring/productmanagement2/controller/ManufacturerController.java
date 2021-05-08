package bogu.spring.productmanagement2.controller;

import bogu.spring.productmanagement2.entities.ManufacturerModel;
import bogu.spring.productmanagement2.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("getManufacturers")
    public List<ManufacturerModel> getAllManufacturers() {
        List<ManufacturerModel> foundManufacturers = manufacturerRepository.findAll();
        return foundManufacturers;
    }

    @GetMapping("getManufacturerById/{id}")
    public ManufacturerModel getManufacturerById(@PathVariable long id) {
        Optional<ManufacturerModel> foundManufacturer = manufacturerRepository.findById(id);
        return foundManufacturer.get();
    }
}
