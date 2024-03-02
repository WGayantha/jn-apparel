package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String emailAddress;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastupdatedDate;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL ,mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<ShopOrder> shopOrders = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserReview>userReviews = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
       this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddresses(Address address) {
        this.addresses.add(address);
    }

    public void removeAddresses(Address address) {
        this.addresses.remove(address);
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void addPaymentMethods(PaymentMethod paymentMethod) {
        this.paymentMethods.add(paymentMethod);
    }

    public void removePaymentMethods(PaymentMethod paymentMethod) {
        this.paymentMethods.remove(paymentMethod);
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

    public List<UserReview> getUserReiews() {
        return userReviews;
    }

    public void addUserReviews(UserReview userReview) {
        this.userReviews.add(userReview);
    }

    public void removeUserReviews(UserReview userReview) {
        this.userReviews.remove(userReview);
    }
}
