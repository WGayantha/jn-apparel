package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String status;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "orderStatus")
    private List<ShopOrder> shopOrders = new ArrayList<>();

    public OrderStatus() {
    }

    public OrderStatus(Long id, String status,
                       List<ShopOrder> shopOrders) {
        this.id = id;
        this.status = status;
        this.shopOrders = shopOrders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
