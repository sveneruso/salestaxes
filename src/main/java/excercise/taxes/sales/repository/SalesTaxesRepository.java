package excercise.taxes.sales.repository;

import java.math.BigDecimal;
import java.util.List;

public interface SalesTaxesRepository {

    BigDecimal getLocalSalesTaxes();

    BigDecimal getImportedSalesTaxes();

    BigDecimal getLocalExcludedSalesTaxes();

    BigDecimal getImportedExcludedSalesTaxes();

    List<String> getLocalExcludedCategory();

    List<String> getImportedExcludedCategory();

}
