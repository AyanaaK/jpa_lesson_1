package ayana_kaldybaeva.jpa_lesson;


import ayana_kaldybaeva.jpa_lesson.entity.Category;
import ayana_kaldybaeva.jpa_lesson.entity.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaLessonMain {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        //взимодействие с сущностями мы строим через EntityManager
        EntityManager manager = factory.createEntityManager();

//
//        Category category = manager.find(Category.class, 2);
//        if (category != null) {
//            System.out.println(category.getName());
//        } else {
//            System.out.println("Категории с заданным 'id' не существует");
//        }

//        Products products = manager.find(Products.class, 1);
//        System.out.printf("Название категории %s\n", products.getCategory().getName());
//        System.out.printf("Название товара %s\n", products.getName());

//        Category category = manager.find(Category.class, 1);
//        System.out.printf("%s: \n", category.getName());
//        List<Products> products = category.getProducts();
//        for (Products products1 : products){
//            System.out.printf("- %s\n",products1.getName());
//        }

        try {
            manager.getTransaction().begin();

            //создание новой категории
//              Category category = new Category();
//              category.setName("Телефоны");
//              manager.persist(category);

            //изменение названия категории
//              Category category = manager.find(Category.class, 3);
//              category.setName("Ноутбуки");

            //удаление категории
            Category category = manager.find(Category.class, 1);
            manager.remove(category);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }


        manager.close();
        factory.close();
    }
}
