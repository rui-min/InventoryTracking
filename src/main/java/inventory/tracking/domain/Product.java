package inventory.tracking.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

/**
 * Domain root class. The single table is declared here.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="p_type")
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private Long product_id;

    @NotNull
    @Column(name="name")
    private String name;    // name must be entered

    @Column(name="price")
    private double price;

    @Column(name="inventory")
    private int inventory;

    @Column(name="type")
    private String type;

    @NotNull
    @Column(name="tag")
    private String tag;

    protected Product() {}

    @JsonCreator
    public Product(@JsonProperty("product_id") Long product_id, @JsonProperty("name") String name,
                           @JsonProperty("price") double price,
                           @JsonProperty("inventory") int inventory,
                           @JsonProperty("type") String type,
                           @JsonProperty("tag") String tag) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.type=type;
        this.tag=tag;
    }

    public Long getId() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    // Name cannot duplicate
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", type='" + type + '\'' +
                ", tag='" + tag + '\'' +
                ", id=" + getId() +
                '}';
    }
}
