package excercise.taxes.sales.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesTaxes {

    private BigDecimal localSalesTax;
    private BigDecimal importedSalesTax;
    private BigDecimal localExcludedSalesTax;
    private BigDecimal importedExcludedSalesTac;
    private List<String> localExcludedCategory = new ArrayList<>();
    private List<String> importedExcludedCategory = new ArrayList<>();

    public SalesTaxes() {
    }

    /**
     * Construtor.
     * @param baseSalesTax The base sale tax
     * @param importedSalesTax The imported sale tac
     * @param localExcludedCategory The category's code to exclude for local category
     * @param importedExcludedCategory The category's code to exclude for imported category
     */
    public SalesTaxes(BigDecimal baseSalesTax, BigDecimal importedSalesTax,
                      List<String> localExcludedCategory,
                      List<String> importedExcludedCategory) {
        this.localSalesTax = baseSalesTax;
        this.importedSalesTax = importedSalesTax;
        this.localExcludedCategory = localExcludedCategory;
        this.importedExcludedCategory = importedExcludedCategory;
    }

    public BigDecimal getLocalSalesTax() {
        return localSalesTax;
    }

    public void setLocalSalesTax(BigDecimal localSalesTax) {
        this.localSalesTax = localSalesTax;
    }

    public BigDecimal getImportedSalesTax() {
        return importedSalesTax;
    }

    public void setImportedSalesTax(BigDecimal importedSalesTax) {
        this.importedSalesTax = importedSalesTax;
    }

    public BigDecimal getLocalExcludedSalesTax() {
        return localExcludedSalesTax;
    }

    public void setLocalExcludedSalesTax(BigDecimal localExcludedSalesTax) {
        this.localExcludedSalesTax = localExcludedSalesTax;
    }

    public BigDecimal getImportedExcludedSalesTac() {
        return importedExcludedSalesTac;
    }

    public void setImportedExcludedSalesTac(BigDecimal importedExcludedSalesTac) {
        this.importedExcludedSalesTac = importedExcludedSalesTac;
    }

    public List<String> getLocalExcludedCategory() {
        return localExcludedCategory;
    }

    public void setLocalExcludedCategory(List<String> localExcludedCategory) {
        this.localExcludedCategory = localExcludedCategory;
    }

    public void addLocalExcludedCategory(String categoryCode) {
        this.localExcludedCategory.add(categoryCode);
    }

    public List<String> getImportedExcludedCategory() {
        return importedExcludedCategory;
    }

    public void setImportedExcludedCategory(List<String> importedExcludedCategory) {
        this.importedExcludedCategory = importedExcludedCategory;
    }

    public void addImportedExcludedCategory(String categoryCode) {
        this.importedExcludedCategory.add(categoryCode);
    }

}
