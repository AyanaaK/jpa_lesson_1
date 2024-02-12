package ayana_kaldybaeva.jpa_lesson;

import ayana_kaldybaeva.jpa_lesson.entity.Category;
import ayana_kaldybaeva.jpa_lesson.entity.Characteristics;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCategoryMain {

    public static void main(String[] args) {
//         Введите название категории: Мониторы
//         Введите характеристики категории: Производитель, Диагональ, Матрица
//
//         1) После ввода названия категории в таблице categories должна быть
//         создана новая запись с введённым названием.
//         2) Создать каждую введённую характеристику как отдельную запись в
//         таблице options которая должна быть привязана к созданной в первом
//         шаге категории.
//
//        String options = "Производитель, Диагональ, Матрица";
//        String[] optionsArray = options.split(", ");
//        System.out.println(optionsArray[0]);
//        System.out.println(optionsArray[1]);
//        System.out.println(optionsArray[2]);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название категории:");
        String categoryName = scanner.nextLine();

        System.out.println("Введите характеристики категории:");
        String optionsNames = scanner.nextLine();
        String[] optionsArray = optionsNames.split(", ");

        try {
            manager.getTransaction().begin();

            //creating new category
            Category category = new Category();
            category.setName(categoryName);
            manager.persist(category);

            //creating new options
            List<Characteristics> characteristicsList = new ArrayList<>();
            for (String optionName : optionsArray) {
                //new characteristics
                Characteristics characteristics = new Characteristics();
                //characteristics name
                characteristics.setName(optionName);
                //characteristics category to not be null
                characteristics.setCategory(category);
                manager.persist(characteristics);
                //adding new characteristics in characteristicsList
                characteristicsList.add(characteristics);
            }


            category.setOptions(characteristicsList);

            manager.getTransaction().commit();

//            Category category = manager.find(Category.class, 12);
//            List<Characteristics> options = category.getOptions();
//            for (Characteristics option : options) {
//                manager.remove(option);
//            }
//            manager.remove(category);
//
////            Characteristics characteristics = manager.find(Characteristics.class, 10);
////            manager.remove(characteristics);
//            manager.getTransaction().commit();

        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

        manager.close();
        factory.close();
    }
}
