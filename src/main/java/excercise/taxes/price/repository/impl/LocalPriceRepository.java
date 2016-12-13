package excercise.taxes.price.repository.impl;

import excercise.taxes.price.model.Price;
import excercise.taxes.price.repository.PriceRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LocalPriceRepository implements PriceRepository{

    private List<Price> priceItems = new ArrayList<Price>() {{
        add(new Price("001", new BigDecimal(12.49)));
        add(new Price("002", new BigDecimal(14.99)));
        add(new Price("003", new BigDecimal(0.850)));
        add(new Price("004", new BigDecimal(10.00)));
        add(new Price("005", new BigDecimal(47.50)));
        add(new Price("006", new BigDecimal(27.99)));
        add(new Price("007", new BigDecimal(18.99)));
        add(new Price("008", new BigDecimal(11.25)));
        add(new Price("009", new BigDecimal(9.75)));
    }};

    private Map<String, Price> priceList = new HashMap<String, Price>(){{
        for(Price price: priceItems) {
            put(price.getProductCode(), price);
        }
    }};

    @Override
    public Price getProductPrice(String productCode) {
        Price productPrice = null;

        if(priceList.containsKey(productCode)) {
            productPrice = priceList.get(productCode);
        }

        return productPrice;
    }
}
