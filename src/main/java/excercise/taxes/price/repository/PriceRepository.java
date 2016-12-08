package excercise.taxes.price.repository;

import excercise.taxes.price.model.Price;

/**
 * @author sveneruso
 */
public interface PriceRepository {

    Price getProductPrice(String productCode);

}
