package excercise.taxes.sales.services;

import java.math.BigDecimal;

public interface SalesTaxesService {

    BigDecimal calculateTaxForProduct(String productCode);

}
