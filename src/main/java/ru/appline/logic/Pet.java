package ru.appline.logic;

public class Pet {

    /*
    {
    "name": "Somename",
    "type": "SomeType",
    "age": 33
    }
     */
    private int id;

    private String name;

    private String type;

    private int age;

    public Pet() {
        super();
    }

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public Pet(String name, String type, int age, int id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}