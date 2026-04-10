package com.study.dsa.week1;

public class SingleResponsibilityPrincipal {
    private int name;
    private int id;
    private int age;
    SingleResponsibilityPrincipal(int name,int id,int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //some DB operations
    public void saveToDatabase() {
        // Code to save the object to a database
        System.out.println("Saving to database: " + this);
    }

    //some validation operations
    public boolean validate() {
        // Code to validate the object's data
        return name > 0 && id > 0 && age > 0;
    }

    // some email trigger
    public void triggerEmail() {
        // Code to trigger an email notification
        System.out.println("Triggering email for: " + this);
    }
}

//optimize Code of SRP by separating concerns into different classes
class User {
    private int name;
    private int id;
    private int age;

    User(int name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class UserService {
    public void saveToDatabase(User user) {
        // Code to save the user to a database
        System.out.println("Saving to database: " + user);
    }

    public boolean validate(User user) {
        // Code to validate the user's data
        return user.getName() > 0 && user.getId() > 0 && user.getAge() > 0;
    }

    public void triggerEmail(User user) {
        // Code to trigger an email notification
        System.out.println("Triggering email for: " + user);
    }
}
