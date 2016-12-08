package excercise.taxes.sales.services;

import java.math.BigDecimal;

/**
 * @author sveneruso
 */
public interface SalesTaxesService {

    BigDecimal calculateTaxForProduct(String productCode);

}
