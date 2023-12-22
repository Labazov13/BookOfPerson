package org.example.controller;

import org.example.JournalMilitary;
import org.example.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InnerRepository implements ActionRepository {

    public JournalMilitary journalMilitary;
    public TXTRepository txtRepository = new TXTRepository();
    public Scanner sc = new Scanner(System.in);

    public InnerRepository(JournalMilitary journalMilitary) {
        this.journalMilitary = journalMilitary;
    }

    public Person createPerson() {
        int ID;
        if (journalMilitary.getPersonList().isEmpty()) {
            ID = journalMilitary.getPersonList().size();
        } else {
            ID = checkID(journalMilitary.getPersonList());
        }
        String name;
        String surname;
        String rank;
        int yearWork;

        System.out.println("Введите имя: ");
        name = sc.next();
        System.out.println("Введите фамилию: ");
        surname = sc.next();
        System.out.println("Введите звание: ");
        rank = sc.next();
        System.out.println("Введите количество лет выслуги: ");
        yearWork = sc.nextInt();
        return new Person(ID, name, surname, rank, yearWork);
    }

    public void searchPerson(String surname) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < journalMilitary.getPersonList().size(); i++) {
            if (journalMilitary.getPersonList().get(i).getSurname().equals(surname)) {
                personList.add(journalMilitary.getPersonList().get(i));
            }
        }
        if (personList.isEmpty()) {
            System.out.println("Военнослужащий не найден");
        }
        personList.forEach(System.out::println);
    }


    @Override
    public void add(Person p) {
        journalMilitary.getPersonList().add(p);
        txtRepository.add(p);
        System.out.println("Добавлен военнослужащий: " + p);
    }

    @Override
    public void delete(String text) {
        List<Person> personList = new ArrayList<>();
        if (journalMilitary.getPersonList().isEmpty()) {
            System.out.println("Список пуст");
        } else {
            personList = journalMilitary.getPersonList().stream().filter(person -> !person.getSurname().equals(text)).toList();
            journalMilitary.getPersonList().stream().filter(person -> person.getSurname().equals(text)).forEach(System.out::println);
        }
        journalMilitary.setPersonList(personList);
        txtRepository.update(personList);
    }

    @Override
    public void print() {
        for (Person p : journalMilitary.getPersonList()) {
            System.out.println(p);
        }
    }

    public int checkID(List<Person> personList) {
        int maxID = personList.size();
        int minID = personList.get(0).getID();
        for (int i = 0; i < personList.size(); i++) {
            if (minID > personList.get(i).getID()) {
                minID = personList.get(i).getID();
            }
        }
        if (minID != 0) {
            return --minID;
        }
        return ++maxID;
    }
}



/*
else {
        personList = journalMilitary.getPersonList().stream().filter(person -> !person.getSurname().equals(text)).toList();
        //for(int i = 0; i < journalMilitary.getPersonList().size(); i++){
        //if (journalMilitary.getPersonList().get(i).getSurname().equals(text)){
        journalMilitary.getPersonList().stream().filter(person -> person.getSurname().equals(text)).forEach(System.out::println);
        //journalMilitary.getPersonList().remove(i);
        //break;
        // }
        // }
        System.out.println("Военнослужащий не найден");
        }*/
