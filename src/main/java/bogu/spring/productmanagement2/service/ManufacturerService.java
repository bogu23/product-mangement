package bogu.spring.productmanagement2.service;

import bogu.spring.productmanagement2.entities.ManufacturerModel;
import bogu.spring.productmanagement2.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<ManufacturerModel> getAll() {
        return manufacturerRepository.findAll();
    }

    public ManufacturerModel getManufacturerById(long id) {
        Optional<ManufacturerModel> foundManufacturer = manufacturerRepository.findById(id);
        ManufacturerModel manufacturerModel = foundManufacturer.get();
        return manufacturerModel;
    }

    public void edit(ManufacturerModel manufacturerModel) {
        if (manufacturerModel.getName() != null) {
            manufacturerRepository.save(manufacturerModel);
        }
        if (manufacturerModel.getName() == null) {
            throw new RuntimeException("You are trying to modify a manufacturer that doesn't exist!!!");
        }
    }

    public void delete(long id) {
        manufacturerRepository.deleteById(id);
    }


}
