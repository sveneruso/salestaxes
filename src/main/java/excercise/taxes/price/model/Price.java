package excercise.taxes.price.model;

import java.math.BigDecimal;

/**
 * @author sveneruso
 */
public class Price {

    private String productCode;
    private BigDecimal price;

    public Price() {
    }

    public Price(String productCode, BigDecimal price) {
        this.productCode = productCode;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
