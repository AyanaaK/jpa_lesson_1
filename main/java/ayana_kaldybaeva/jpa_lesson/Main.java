package ayana_kaldybaeva.jpa_lesson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Что вы хотите сделать? Выберите номер");
            System.out.println("1. Изменить продукт");
            System.out.println("2. Создать категорию");
            System.out.println("3. Создать продукт");
            System.out.println("4. Удалить продукт");
            System.out.println("5. Выйти");

            System.out.print("Номер: ");

            Scanner scanner = new Scanner(System.in);
            int actionToDo = Integer.parseInt(scanner.nextLine());

            switch (actionToDo) {
                case 1:
                    ChangeProducts.change();
                    break;
                case 2:
                    CreateCategory.create();
                    break;
                case 3:
                    CreateProducts.create();
                    break;
                case 4:
                    DeleteProducts.delete();
                    break;
                case 5:
                    System.out.println("Вы вышли из программы");
                    return;
                default:
                    System.out.println("Неверный номер действия. Попробуйте заново");
                    break;
            }
        }
    }
}
