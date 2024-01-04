package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String value;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "paymentType")
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public PaymentType() {
    }

    public PaymentType(Long id, String value,
                       List<PaymentMethod> paymentMethods) {
        this.id = id;
        this.value = value;
        this.paymentMethods = paymentMethods;
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

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void addPaymentMethods(PaymentMethod paymentMethod) {
        this.paymentMethods.add(paymentMethod);
    }

    public void removePaymentMethods(PaymentMethod paymentMethod) {
        this.paymentMethods.remove(paymentMethod);
    }
}
