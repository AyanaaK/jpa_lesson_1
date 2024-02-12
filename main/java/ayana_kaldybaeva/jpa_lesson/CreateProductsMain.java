package ayana_kaldybaeva.jpa_lesson;

import ayana_kaldybaeva.jpa_lesson.entity.Category;
import ayana_kaldybaeva.jpa_lesson.entity.Characteristics;
import ayana_kaldybaeva.jpa_lesson.entity.Products;
import ayana_kaldybaeva.jpa_lesson.entity.Values;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class CreateProductsMain {
    public static void main(String[] args) {
        //         Введите название продукта: Asus Tuf gaming f15
//         Введите цену продукта: 680_000
//         Введите айди категории: 3
//
//         1) После ввода названия категории названия продукта и цены в таблице products должна быть
//         создана новая запись с введённым названием.

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите айди категории:");
        Long categoryId = Long.parseLong(scanner.nextLine());

        //scanner.nextLine();

        System.out.println("Введите название продукта:");
        String productName = scanner.nextLine();

        System.out.println("Введите цену продукта");
        Integer productPrice = Integer.parseInt(scanner.nextLine());

        try {
            manager.getTransaction().begin();

            Category category = manager.find(Category.class, categoryId);

            Products products1 = new Products();
            products1.setName(productName);
            products1.setPrice(productPrice);
            products1.setCategory(category);
            manager.persist(products1);

            List<Characteristics> characteristicsList = category.getOptions();

            for (Characteristics characteristic : characteristicsList) {
                System.out.println("Введите значение для " + characteristic.getName());
                String value = scanner.nextLine();
                //scanner.nextLine();

                Values values = new Values();
                values.setCharacteristics(characteristic);
                values.setProducts(products1);
                values.setValue(value);
                manager.persist(values);
            }

            manager.getTransaction().commit();

        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

        manager.close();
        factory.close();
    }

}
