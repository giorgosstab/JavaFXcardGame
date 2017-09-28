/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxCardGame.engine.gameEngine;

/**
 * @author Been Touched
 */
public class Human {
    protected String name;
    protected String surname;
    protected int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String introduceSelf() {
        return "Hello, I'm " + this.name + " " + this.surname + ", " + this.age + " years old.";
    }
}
