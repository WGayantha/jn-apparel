package lk.jnapparel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Variation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "variation")
    private List<VariationOption> variationOptions = new ArrayList<>();

    public Variation() {
    }

    public Variation(Long id,
                     String name,
                     Category category,
                     List<VariationOption> variationOptions) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.variationOptions = variationOptions;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
