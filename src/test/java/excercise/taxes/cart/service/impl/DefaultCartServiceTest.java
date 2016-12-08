package excercise.taxes.cart.service.impl;

import excercise.taxes.cart.model.Cart;
import excercise.taxes.cart.model.CartItem;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author sveneruso
 */
public class DefaultCartServiceTest {


    private DefaultCartService cartService;

    @Before
    public void setUp() {
        cartService = new DefaultCartService();
    }

    @Test
    public void test_1() {

        CartItem item = new CartItem("PRD_001", 1, new BigDecimal(12.49), new BigDecimal(0), new BigDecimal(12.49));

        Cart cart = cartService.addCartItem(item);

        assertNotNull("The cart is not null", cart);
        assertEquals("The cart total is correct", 12.49, cart.getCartTotal().doubleValue(), 0.0);
        assertEquals("The cart tax total is correct", 0.00, cart.getCartTaxTotal().doubleValue(), 0.0);
    }

    @Test
    public void test_2() {
        Cart cart;
        CartItem item;

        item = new CartItem("PRD_001", 1, new BigDecimal(12.49), new BigDecimal(0), new BigDecimal(12.49));
        cart = cartService.addCartItem(item);

        item = new CartItem("PRD_002", 1, new BigDecimal(14.99), new BigDecimal(1.50), new BigDecimal(16.49));
        cart = cartService.addCartItem(item);

        item = new CartItem("PRD_003", 1, new BigDecimal(0.85), new BigDecimal(0), new BigDecimal(0.85));
        cart = cartService.addCartItem(item);

        assertNotNull("The cart is not null", cart);
        assertEquals("The cart total is correct", 29.83, cart.getCartTotal().doubleValue(), 0.0);
        assertEquals("The cart tax total is correct", 1.50, cart.getCartTaxTotal().doubleValue(), 0.0);
    }

    @Test
    public void test_3() {
        Cart cart;
        CartItem item;

        item = new CartItem("PRD_001", 1, new BigDecimal(10.00), new BigDecimal(0.50), new BigDecimal(10.50));
        cart = cartService.addCartItem(item);

        item = new CartItem("PRD_002", 1, new BigDecimal(47.50), new BigDecimal(7.15), new BigDecimal(54.65));
        cart = cartService.addCartItem(item);

        assertNotNull("The cart is not null", cart);
        assertEquals("The cart total is correct", 65.15, cart.getCartTotal().doubleValue(), 0.0);
        assertEquals("The cart tax total is correct", 7.65, cart.getCartTaxTotal().doubleValue(), 0.0);
    }

    @Test
    public void test_4() {
        Cart cart;
        CartItem item;

        item = new CartItem("PRD_001", 1, new BigDecimal(27.99), new BigDecimal(4.20), new BigDecimal(32.19));
        cart = cartService.addCartItem(item);

        item = new CartItem("PRD_002", 1, new BigDecimal(18.99), new BigDecimal(1.90), new BigDecimal(20.89));
        cart = cartService.addCartItem(item);

        item = new CartItem("PRD_003", 1, new BigDecimal(9.75), new BigDecimal(0), new BigDecimal(9.75));
        cart = cartService.addCartItem(item);

        item = new CartItem("PRD_003", 1, new BigDecimal(11.25), new BigDecimal(0.60), new BigDecimal(11.85));
        cart = cartService.addCartItem(item);

        assertNotNull("The cart is not null", cart);
        assertEquals("The cart total is correct", 74.68, cart.getCartTotal().doubleValue(), 0.0);
        assertEquals("The cart tax total is correct", 6.70, cart.getCartTaxTotal().doubleValue(), 0.0);
    }
}