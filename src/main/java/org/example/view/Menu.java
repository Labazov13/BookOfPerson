package org.example.view;

import org.example.Person;
import org.example.controller.InnerRepository;
import java.util.Scanner;

public class Menu {
    InnerRepository innerRepository;
    Scanner sc = new Scanner(System.in);
    String text;

    public Menu(InnerRepository innerRepository) {
        this.innerRepository = innerRepository;
    }

    public void run() {
        int switcher = 0;

        while (switcher != 5) {
            System.out.println("Выберите действие: \n " +
                    "1 - Добавить контакт \n " +
                    "2 - Найти контакт \n " +
                    "3 - Удалить контакт \n " +
                    "4 - Просмотреть журнал \n" +
                    " 5 - Выход");
            switcher = sc.nextInt();

            switch (switcher) {
                case 1:
                    Person p = innerRepository.createPerson();
                    innerRepository.add(p);
                    break;
                case 2:
                    text = search();
                    innerRepository.searchPerson(text);
                    break;
                case 3:
                    text = search();
                    innerRepository.delete(text);
                    break;
                case 4:
                    innerRepository.print();

            }
        }
        sc.close();
    }
    public String search(){
        System.out.println("Введите фамилию военнослужащего: ");
        return sc.next();
    }
}
