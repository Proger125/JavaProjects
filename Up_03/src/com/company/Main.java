package com.company;

import com.company.Model.Country;
import com.company.Model.Model;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Model model = new Model();
        model.addElement(new Country("Франция", "plain/flag_france.png"), "Париж");
        model.addElement(new Country("Италия", "plain/flag_italy.png"), "Рим");
        model.addElement(new Country("Германия", "plain/flag_germany.png"), "Берлин");
        model.addElement(new Country("Швейцария", "plain/flag_switzerland.png"), "Женева");
        model.addElement(new Country("Монако", "plain/flag_monaco.png"), "Монако");
	    View view = new View("Countries", model);
    }
}
