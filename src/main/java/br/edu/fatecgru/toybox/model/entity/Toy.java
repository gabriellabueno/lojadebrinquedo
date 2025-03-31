package br.edu.fatecgru.toybox.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="toy")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_toy")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description")
    private String description;


    // Muitos brinquedos podem pertencer a 1 única categoria
    @ManyToOne(fetch = FetchType.LAZY)

    // Referencia chave primária de Category
    @JoinColumn(name = "fk_id_category", nullable = false,
            foreignKey = @ForeignKey(name = "fk_toy_category")) // Nome da Constraint
    private Category category; // Objeto que representa entidade category



    public Toy() {
    }

    public Toy(String name, BigDecimal price, String brand, String image, String description, Category category) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.image = image;
        this.description = description;
        this.category = category;
    }


    public Integer getId() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return category.getId();
    }

}
