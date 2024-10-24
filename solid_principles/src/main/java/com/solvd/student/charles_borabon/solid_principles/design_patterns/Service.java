package com.solvd.student.charles_borabon.solid_principles.design_patterns;

public class Service implements EventListener {
    @Override
    public void onEvent(String event) {
        // Handle the event
        System.out.println("Event received: " + event);
    }
}
