package bogu.spring.productmanagement2.service;

import bogu.spring.productmanagement2.entities.CartModel;
import bogu.spring.productmanagement2.entities.ClientModel;
import bogu.spring.productmanagement2.entities.OrderStatusModel;
import bogu.spring.productmanagement2.entities.ProductModel;
import bogu.spring.productmanagement2.repository.CartRepository;
import bogu.spring.productmanagement2.repository.ClientRepository;
import bogu.spring.productmanagement2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;


    public void registerClient(ClientModel clientModel) {
        //adauga carucior pe client
        clientRepository.save(clientModel);
    }

    public void addToCart(long clientId, long productId) {
        Optional<ProductModel> productModelOptional = productRepository.findById(productId);
        if (productModelOptional.isEmpty()) {
            throw new RuntimeException("Product dosen't exist!!!");
        }
        ProductModel productModel = productModelOptional.get();

        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if (clientModelOptional.isEmpty()) {
            throw new RuntimeException("Client not exists");
        }
        ClientModel clientModel = clientModelOptional.get();

        List<CartModel> cartModelList = clientModel.getCarts();

        CartModel cartFound = null;
        for (CartModel cart : cartModelList) {
            if (cart.getStatus().equals(OrderStatusModel.OPEN)) {
                cartFound = cart;
            }
        }

        if (cartFound == null) {
            cartFound = new CartModel();
            cartFound.setStatus(OrderStatusModel.OPEN);
            cartFound.setClientModel(clientModel);
        }
        cartFound.getProducts().add(productModel);

        double total = 0;

        for (ProductModel productModel1 : cartFound.getProducts()) {
            total += productModel1.getPrice();
        }
        cartFound.setTotal(total);

        cartRepository.save(cartFound);
    }

    public List<CartModel> getAllCarts(long clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if (clientModelOptional.isEmpty()) {
            throw new RuntimeException("Client doesn't exist!");
        }
        ClientModel clientModel = clientModelOptional.get();
        List<CartModel> carts = clientModel.getCarts();

        return carts;
    }

    public CartModel getCart(long clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if (clientModelOptional.isEmpty()) {
            throw new RuntimeException("Client not exist!!!");
        }
        ClientModel clientModel = clientModelOptional.get();

        List<CartModel> cartModels = clientModel.getCarts();
        CartModel foundCart = null;

        double total = 0;
        for (CartModel cart : cartModels) {
            if (cart.getStatus().equals(OrderStatusModel.OPEN)) {
                foundCart = cart;
            }
        }

        if (foundCart != null) {
            for (ProductModel productModel1 : foundCart.getProducts()) {
                total += productModel1.getPrice();
            }
            foundCart.setTotal(total);
        }

        return foundCart;
    }

    public void changeStatus(long cartId) {
        Optional<CartModel> foundCart = cartRepository.findById(cartId);
        if (foundCart.isEmpty()) {
            throw new RuntimeException("Cart not found!!");
        }
        CartModel cartModel = foundCart.get();

        if (cartModel.getStatus().equals(OrderStatusModel.OPEN)) {
            cartModel.setStatus(OrderStatusModel.DELIVERED);
        }

        cartRepository.save(cartModel);

    }

}
