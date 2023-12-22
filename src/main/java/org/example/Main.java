package org.example;

import org.example.controller.InnerRepository;
import org.example.view.Menu;

public class Main {
    public static void main(String[] args) {
        JournalMilitary journalMilitary = new JournalMilitary();
        InnerRepository innerRepository = new InnerRepository(journalMilitary);
        Menu menu = new Menu(innerRepository);
        menu.run();
    }
}