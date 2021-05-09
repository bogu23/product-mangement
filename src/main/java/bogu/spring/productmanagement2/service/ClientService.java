package bogu.spring.productmanagement2.service;

import bogu.spring.productmanagement2.entities.ClientModel;
import bogu.spring.productmanagement2.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public void registerClient(ClientModel clientModel) {
        //adauga carucior pe client
        clientRepository.save(clientModel);
    }
}
