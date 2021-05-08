package bogu.spring.productmanagement2.controller;

import bogu.spring.productmanagement2.entities.ManufacturerModel;
import bogu.spring.productmanagement2.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<ManufacturerModel> getAllManufacturers() {
        List<ManufacturerModel> foundManufacturers = manufacturerRepository.findAll();
        return foundManufacturers;
    }
}
