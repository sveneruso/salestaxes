package excercise.taxes.product.model;

/**
 * @author sveneruso
 */
public class Product {

    private String code;
    private String name;
    private String categoryCode;
    private boolean imported;

    public Product() {
    }

    public Product(String code, String name, String categoryCode, boolean imported) {
        this.code = code;
        this.name = name;
        this.categoryCode = categoryCode;
        this.imported = imported;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }
}
