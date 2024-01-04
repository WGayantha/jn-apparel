package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false)
    private int qtyInStock;

    @Column(nullable = false)
    private String productImage;

    @Column(nullable = false)
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_CONFIGURATION",
            joinColumns = @JoinColumn(name = "PRODUCT_ITEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "VARIATION_OPTION_ID"))
    private List<VariationOption> variationOptions = new ArrayList<>();

    public ProductItem() {
    }

    public ProductItem(Long id,
                       String sku,
                       int qtyInStock,
                       String productImage,
                       double price,
                       Product product,
                       List<VariationOption> variationOptions) {
        this.id = id;
        this.sku = sku;
        this.qtyInStock = qtyInStock;
        this.productImage = productImage;
        this.price = price;
        this.product = product;
        this.variationOptions = variationOptions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<VariationOption> getVariationOptions() {
        return variationOptions;
    }

    public void addVariationOptions(VariationOption variationOption) {
        this.variationOptions.add(variationOption);
    }

    public void removeVariationOptions(VariationOption variationOption) {
        this.variationOptions.remove(variationOption);
    }
}
