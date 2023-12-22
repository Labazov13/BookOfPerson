package org.example;

public class Person {
    private String name;
    private String surname;
    private String rank;
    private int yearsOfWork;
    private int ID;

    public Person(int ID, String name, String surname, String rank, int yearsOfWork) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.rank = rank;
        this.yearsOfWork = yearsOfWork;
    }



    @Override
    public String toString() {
        return "ID = " + "{" + ID + "}" +
               " Имя = " + "{" +name + "}" +
               " Фамилия = " + "{" +surname + "}" +
               " Звание = " + "{" + rank + "}" +
               " Выслуга = " + "{" + yearsOfWork + "}" + " лет";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRank() {
        return rank;
    }

    public int getYearsOfWork() {
        return yearsOfWork;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setYearsOfWork(int yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
