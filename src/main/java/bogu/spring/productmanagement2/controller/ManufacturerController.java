package bogu.spring.productmanagement2.controller;

import bogu.spring.productmanagement2.entities.ManufacturerModel;
import bogu.spring.productmanagement2.repository.ManufacturerRepository;
import bogu.spring.productmanagement2.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("getManufacturers")
    public List<ManufacturerModel> getAllManufacturers() {
        return manufacturerService.getAll();
    }

    @PostMapping("addManufacturer")
    public ResponseEntity addManufacturer(@RequestBody ManufacturerModel manufacturerModel) {
        try {
            manufacturerService.add(manufacturerModel);
            return ResponseEntity.ok("Manufacturer added successfully!");
        } catch (RuntimeException runtimeException) {
            return new ResponseEntity<Object>("Manufacturer NOT added! Something went wrong!!",
                                                    new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getManufacturerById/{id}")
    public ManufacturerModel getManufacturerById(@PathVariable long id) {
       ManufacturerModel manufacturerModel = manufacturerService.getManufacturerById(id);
       return manufacturerModel;
    }

    @PutMapping("editManufacturer")
    public void editManufacturer(@RequestBody ManufacturerModel manufacturerToBeEdit) {
        manufacturerService.edit(manufacturerToBeEdit);
    }

    @DeleteMapping("deleteManufacturer/{id}")
    public void deleteManufacturerById(@PathVariable long id) {
        manufacturerService.delete(id);
    }


}
