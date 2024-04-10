package ayana_kaldybaeva.jpa_lesson;

import ayana_kaldybaeva.jpa_lesson.entity.Products;
import ayana_kaldybaeva.jpa_lesson.entity.Values;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class ChangeProducts {
    public static void change() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID продукта, который желаете изменить: ");
        Long productId = Long.parseLong(scanner.nextLine());

        try {
            manager.getTransaction().begin();

            Products products = manager.find(Products.class, productId);

            System.out.println("Введите новое название товара: ");
            String newProductName = scanner.nextLine();
            if (!newProductName.isEmpty()) {
                products.setName(newProductName);
            }

            System.out.println("Введите новую цену продукта: ");
            String newProductPriceString = scanner.nextLine();
            if (!newProductPriceString.isEmpty()) {
                Integer newProductPrice = Integer.parseInt(newProductPriceString);
                products.setPrice(newProductPrice);
            }

            List<Values> valuesList = products.getValues();

            for (Values values1 : valuesList) {
                System.out.println("Введите новое значение для " + values1.getCharacteristics().getName());
                String newValue = scanner.nextLine();
                if (!newValue.isEmpty()) {
                    values1.setValue(newValue);
                }
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException();
        }

        manager.close();
        factory.close();
    }
}
