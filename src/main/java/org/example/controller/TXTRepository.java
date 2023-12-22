package org.example.controller;

import org.example.Person;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TXTRepository implements ActionRepository {

    private final String fileName = "MilitaryJournal.txt";

    File file = new File(fileName);

    @Override
    public void add(Person p) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(p + "\n");
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void delete(String text) {

    }

    @Override
    public void print() {

    }

    public void update(List<Person> personList) {
        try (FileWriter writer = new FileWriter(file, false)) {
            for (Person person : personList) {
                writer.write(person + "\n");
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
