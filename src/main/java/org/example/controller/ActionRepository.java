package org.example.controller;

import org.example.Person;

public interface ActionRepository {
    void add(Person p);
    void delete(String text);
    void print();
}
