package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String sku;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String productImage;

    @Column(nullable = false)
    private int qtyInStock;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastupdatedDate;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrderLine> orderLines = new ArrayList<>();

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void addShoppingCartItems(ShoppingCartItem shoppingCartItem) {
        this.shoppingCartItems.add(shoppingCartItem);
    }

    public void removeShoppingCartItems(ShoppingCartItem shoppingCartItem) {
        this.shoppingCartItems.remove(shoppingCartItem);
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void addOrderLines(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }

    public void removeOrderLines(OrderLine orderLine) {
        this.orderLines.remove(orderLine);
    }
}

