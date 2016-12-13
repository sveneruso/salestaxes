package excercise.taxes.price.repository;

import excercise.taxes.price.model.Price;

public interface PriceRepository {

    Price getProductPrice(String productCode);

}
