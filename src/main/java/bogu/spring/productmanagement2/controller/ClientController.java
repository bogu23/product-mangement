package bogu.spring.productmanagement2.controller;

import bogu.spring.productmanagement2.entities.CartModel;
import bogu.spring.productmanagement2.entities.ClientModel;
import bogu.spring.productmanagement2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("register")
    public void registerClient(@RequestBody ClientModel clientModel) {
        clientService.registerClient(clientModel);
    }

    @PutMapping("addToCart/{clientId}/{productId}")
    public void addToCart(@PathVariable long clientId,@PathVariable long productId) {
        clientService.addToCart(clientId, productId);
    }

    @GetMapping("getCart/{clientId}")
    public CartModel getCart(@PathVariable long clientId) {
        CartModel cartModel = clientService.getCart(clientId);
        return cartModel;
    }


}
