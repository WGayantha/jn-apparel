package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "orderLine")
    private List<UserReview> userReviews =  new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private ShopOrder shopOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_item")
    private Product product;

    public OrderLine() {
    }

    public OrderLine(Long id,
                     int quantity,
                     double price,
                     List<UserReview> userReviews,
                     ShopOrder shopOrder,
                     Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.userReviews = userReviews;
        this.shopOrder = shopOrder;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<UserReview> getUserReviews() {
        return userReviews;
    }

    public void addUserReviews(UserReview userReview) {
        this.userReviews.add(userReview);
    }

    public void removeUserReviews(UserReview userReview) {
        this.userReviews.remove(userReview);
    }

    public ShopOrder getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(ShopOrder shopOrder) {
        this.shopOrder = shopOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
