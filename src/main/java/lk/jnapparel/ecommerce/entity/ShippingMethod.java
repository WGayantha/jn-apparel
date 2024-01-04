package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "shippingMethod")
    private List<ShopOrder> shopOrders = new ArrayList<>();

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ShopOrder> getShopOrders() {
        return shopOrders;
    }

    public void addShopOrders(ShopOrder shopOrder) {
        this.shopOrders.add(shopOrder);
    }

    public void removeShopOrders(ShopOrder shopOrder) {
        this.shopOrders.remove(shopOrder);
    }
}
