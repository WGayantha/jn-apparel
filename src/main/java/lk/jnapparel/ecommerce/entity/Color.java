package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String value;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "color")
    private List<Product> products = new ArrayList<>();

    public Color() {
    }

    public Color(Long id, String value, List<Product> products) {
        this.id = id;
        this.value = value;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public void removeProducts(Product product) {
        this.products.remove(product);
    }
}
