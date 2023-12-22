package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JournalMilitary {
    private List<Person> personList;

    public JournalMilitary() {
        this.personList = fillList();
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> fillList() {
        String fileName = "MilitaryJournal.txt";
        List<String> listPersons = new ArrayList<>();
        List<Person> listPerson = new ArrayList<>();
        List<String> dataPerson = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready()) {
                listPersons.add(bufferedReader.readLine());
            }
            for (String data : listPersons) {
                Pattern pattern = Pattern.compile("\\{([^{}]+)\\}");
                Matcher matcher = pattern.matcher(data);
                while (matcher.find()) {
                    dataPerson.add(matcher.group(1));
                }
                int i = 0;
                int ID = Integer.parseInt(dataPerson.get(i++));
                String name = dataPerson.get(i++);
                String surname = dataPerson.get(i++);
                String rank = dataPerson.get(i++);
                int yearWork = Integer.parseInt(dataPerson.get(i));
                listPerson.add(new Person(ID, name, surname, rank, yearWork));
                dataPerson.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listPerson;
    }
}
