package excercise.taxes.sales.repository.impl;

import excercise.taxes.sales.repository.SalesTaxesRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class LocalSalesTaxesRepository implements SalesTaxesRepository {

    private final static BigDecimal LOCAL_SALES_TAXES = new BigDecimal(10);
    private final static BigDecimal IMPORTED_SALES_TAXES = new BigDecimal(5);
    private final static BigDecimal LOCAL_EXCLUDED_SALES_TAXES = BigDecimal.ZERO;
    private final static BigDecimal IMPORTED_EXCLUDED_SALES_TAXES = BigDecimal.ZERO;


    private List<String> localExcludedCategory = new ArrayList<String>() {{
        add("c_001");
        add("c_003");
        add("c_005");
    }};

    private List<String> importedExcludedCategory = new ArrayList<>();

    @Override
    public BigDecimal getLocalSalesTaxes() {
        return LOCAL_SALES_TAXES;
    }

    @Override
    public BigDecimal getImportedSalesTaxes() {
        return IMPORTED_SALES_TAXES;
    }

    @Override
    public BigDecimal getLocalExcludedSalesTaxes() {
        return LOCAL_EXCLUDED_SALES_TAXES;
    }

    @Override
    public BigDecimal getImportedExcludedSalesTaxes() {
        return IMPORTED_EXCLUDED_SALES_TAXES;
    }

    @Override
    public List<String> getLocalExcludedCategory() {
        return localExcludedCategory;
    }

    @Override
    public List<String> getImportedExcludedCategory() {
        return importedExcludedCategory;
    }
}
