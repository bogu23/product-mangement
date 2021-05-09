package bogu.spring.productmanagement2.controller;

import bogu.spring.productmanagement2.entities.ClientModel;
import bogu.spring.productmanagement2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("register")
    public void registerClient(@RequestBody ClientModel clientModel) {
        clientService.registerClient(clientModel);
    }

    @PutMapping("addToCart")
    public void addToCart(long clientId, long productId) {

        clientService.addToCart(clientId, productId);
    }
}
