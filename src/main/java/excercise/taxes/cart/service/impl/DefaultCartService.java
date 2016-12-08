package excercise.taxes.cart.service.impl;

import excercise.taxes.cart.model.Cart;
import excercise.taxes.cart.model.CartItem;
import excercise.taxes.cart.service.CartService;

/**
 * @author sveneruso
 */
public class DefaultCartService implements CartService {

    private Cart cart = new Cart();

    @Override
    public Cart addCartItem(CartItem item) {
        cart.addItem(item);
        return cart;
    }
}
