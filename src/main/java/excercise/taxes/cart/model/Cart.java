package excercise.taxes.cart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sveneruso
 */
public class Cart {

    private List<CartItem> items = new ArrayList<>();
    private BigDecimal cartTotal = BigDecimal.ZERO;
    private BigDecimal cartTaxTotal = BigDecimal.ZERO;

    public Cart() {
    }

    public void addItem(CartItem item) {
        this.items.add(item);

        BigDecimal itemTotal = item.getGrossPrice().multiply(new BigDecimal(item.getQuantity()));

        this.cartTotal = this.cartTotal.add(itemTotal).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.cartTaxTotal = this.cartTaxTotal.add(item.getProductTax()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {

        for(CartItem newItem : items) {
            this.addItem(newItem);
        }

    }

    public BigDecimal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(BigDecimal cartTotal) {
        this.cartTotal = cartTotal;
    }

    public BigDecimal getCartTaxTotal() {
        return cartTaxTotal;
    }

    public void setCartTaxTotal(BigDecimal cartTaxTotal) {
        this.cartTaxTotal = cartTaxTotal;
    }
}
