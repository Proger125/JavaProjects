package com.company;

import com.company.Model.Model;
import com.company.Model.Tour;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        model.addTour(new Tour(null, "Итого: ", 0.0, null));
        model.addTour(new Tour(new ImageIcon("plain/flag_armenia.png"), "Trip to ancient Erevan", 500.0, false));
        model.addTour(new Tour(new ImageIcon("plain/flag_australia.png"), "Australian beaches tour", 900.0, false));
        model.addTour(new Tour(new ImageIcon("plain/flag_bahrain.png"), "Ancient mosques in Bahrain", 1300.0, false));
        View view = new View("Tours", model);
    }
}
