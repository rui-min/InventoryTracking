package inventory.tracking.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public abstract class ProductElectronics extends Product {
    protected ProductElectronics() {}

    @JsonCreator
    public ProductElectronics(@JsonProperty("product_id") Long product_id, @JsonProperty("name") String name,
                           @JsonProperty("price") double price,
                           @JsonProperty("inventory") int inventory,
                           @JsonProperty("type") String type,
                           @JsonProperty("tag") String tag) {
        super(product_id,name,price,inventory, type, tag);
        this.setType("electronics");
    }

}
