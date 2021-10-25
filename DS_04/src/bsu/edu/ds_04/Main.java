package bsu.edu.ds_04;

import bsu.edu.ds_04.model.CustomModel;
import bsu.edu.ds_04.view.CustomView;

public class Main {
    public static void main(String[] args) {
        CustomModel model = new CustomModel();
        CustomView view = new CustomView("Ds_04", model);
        String str = "123456" + "78910";
    }
}
