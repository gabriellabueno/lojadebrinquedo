package br.edu.fatecgru.toybox.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="toy")
public class ToyEntity {

    @Id
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    // Para operações de escrita
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;


    public ToyEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer category) {
        this.categoryId = category;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

}
