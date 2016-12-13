package excercise.taxes.cart.service;

import excercise.taxes.cart.model.Cart;
import excercise.taxes.cart.model.CartItem;

public interface CartService {

    Cart addCartItem(CartItem item);

}
