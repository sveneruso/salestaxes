package excercise.taxes.product.model;

public class Product {

    private String code;
    private String name;
    private String categoryCode;
    private boolean imported;

    public Product() {
    }

    /**
     * Constructor.
     * @param code The code of the product
     * @param name The name of the product
     * @param categoryCode The code of the product's category
     * @param imported If the product is imported or not
     */
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
