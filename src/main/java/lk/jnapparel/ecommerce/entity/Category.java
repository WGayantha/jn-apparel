package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private List<Variation> variations = new ArrayList<>();


    public Category() {
    }

    public Category(Long id,
                    String categoryName,
                    List<Product> products,
                    List<Variation> variations) {
        this.id = id;
        this.categoryName = categoryName;
        this.products = products;
        this.variations = variations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public void removeProducts(Product product) {
        this.products.remove(product);
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void addVariations(Variation variation) {
        this.variations.add(variation);
    }

    public void removeVariations(Variation variation) {
        this.variations.remove(variation);
    }
}
