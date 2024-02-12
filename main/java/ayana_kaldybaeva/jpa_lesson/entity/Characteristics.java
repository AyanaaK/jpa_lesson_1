package ayana_kaldybaeva.jpa_lesson.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "characteristics")


public class Characteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;

    public List<Values> getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }

    @OneToMany(mappedBy = "characteristics")
    private List<Values> values;

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
