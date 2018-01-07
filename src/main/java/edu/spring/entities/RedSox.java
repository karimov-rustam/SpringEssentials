package edu.spring.entities;

//@Component
public class RedSox implements Team {
    @Override
    public String getName() {
        return "Boston Red Sox";
    }

    public String toString() {
        return getName();
    }
}
