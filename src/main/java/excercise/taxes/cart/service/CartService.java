package excercise.taxes.cart.service;

import excercise.taxes.cart.model.Cart;
import excercise.taxes.cart.model.CartItem;

/**
 * @author sveneruso
 */
public interface CartService {

    Cart addCartItem(CartItem Item);

}
