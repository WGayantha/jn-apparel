package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart")
    private ShoppingCart shoppingCart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_item")
    private ProductItem productItem;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Long id, int quantity,
                            ShoppingCart shoppingCart,
                            ProductItem productItem) {
        this.id = id;
        this.quantity = quantity;
        this.shoppingCart = shoppingCart;
        this.productItem = productItem;
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }
}
