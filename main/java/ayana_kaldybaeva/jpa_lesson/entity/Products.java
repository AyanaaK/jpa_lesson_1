package ayana_kaldybaeva.jpa_lesson.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    //@OneToMany - один ко многим
    //@ManyToOne - много к одному

    //много товаров ссылается на одну категорию
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private Integer price;



    @OneToMany(mappedBy = "products")
    private List<Values> values;

    public List<Values> getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
