package inventory.tracking.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CellPhones extends ProductElectronics {
    protected CellPhones() {}

    @JsonCreator
    public CellPhones(@JsonProperty("product_id") Long product_id, @JsonProperty("name") String name,
                      @JsonProperty("price") double price,
                      @JsonProperty("inventory") int inventory,
                      @JsonProperty("type") String type,
                      @JsonProperty("tag") String tag) {
        super(product_id,name,price,inventory,type,tag);
        this.setTag("cellphone");
    }

}
