package edu.spring.entities;

//@Component
public class Cubs implements Team {
    @Override
    public String getName() {
        return "Chicago Cubs";
    }

    public String toString() {
        return getName();
    }
}
