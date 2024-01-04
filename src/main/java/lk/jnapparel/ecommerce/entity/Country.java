package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String countryName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    private List<Address>addresses =new ArrayList<>();

    public Country() {
    }

    public Country(Long id, String countryName, List<Address> addresses) {
        this.id = id;
        this.countryName = countryName;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
}
