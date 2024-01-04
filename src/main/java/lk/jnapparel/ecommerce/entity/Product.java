package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String productImage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductItem> productItems = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String name,
                   String productImage,
                   Category category,
                   List<ProductItem> productItems) {
        this.id = id;
        this.name = name;
        this.productImage = productImage;
        this.category = category;
        this.productItems = productItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

