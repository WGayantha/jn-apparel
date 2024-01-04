package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class VariationOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "variation_id")
    private Variation variation;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "variationOptions")
    private List<ProductItem> productItems = new ArrayList<>();

    public VariationOption() {
    }

    public VariationOption(Long id,
                           String value,
                           Variation variation,
                           List<ProductItem> productItems) {
        this.id = id;
        this.value = value;
        this.variation = variation;
        this.productItems = productItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Variation getVariation() {
        return variation;
    }

    public void setVariation(Variation variation) {
        this.variation = variation;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void addProductItems(ProductItem productItem) {
        this.productItems.add(productItem);
    }
    public void removeProductItems(ProductItem productItem) {
        this.productItems.remove(productItem);
    }
}
