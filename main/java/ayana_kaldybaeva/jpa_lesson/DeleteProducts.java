package ayana_kaldybaeva.jpa_lesson;

import ayana_kaldybaeva.jpa_lesson.entity.Products;
import ayana_kaldybaeva.jpa_lesson.entity.Values;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class DeleteProducts {
    public static void delete() {
        EntityManagerFactory factory = EntityManagerFactoryHolder.factory();
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID продукта, который желаете удалить: ");
        Long productId = Long.parseLong(scanner.nextLine());

        try {
            manager.getTransaction().begin();

            Products products = manager.find(Products.class, productId);

            List<Values> values = products.getValues();
            for (Values values1 : values) {
                manager.remove(values1);
            }
            manager.remove(products);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
