package ayana_kaldybaeva.jpa_lesson.entity;

import jakarta.persistence.*;

import java.util.List;

//регистрируем класс как сущность в модуле jpa,
// что означает что класс может сереализовывваться в табличные данные
// и наоборот в объект
@Entity
//после аннотации entity надо реализовыввать анотацию table
@Table(name = "categories")
//расписываем сущность для таблицы categories



public class Category {

    //у каждой сущности должен быть первичный ключ,
    //делается это с помощью данной аннотации
    @Id
    //значение для поля id не должно требоваться со стороны программы,
    //значение для этого поля будет генерироваться каким-то из заранее
    //определенных стандартных способов
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //mappedBy указывается название сущности Product которая ссылается
    //на категорию, поле класса а не таблицы
    @OneToMany(mappedBy = "category")
    private List<Products> products;

    @OneToMany(mappedBy = "category")
    private List<Characteristics> options;

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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Characteristics> getOptions() {
        return options;
    }

    public void setOptions(List<Characteristics> options) {
        this.options = options;
    }
}
