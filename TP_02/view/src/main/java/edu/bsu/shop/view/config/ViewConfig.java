package edu.bsu.shop.view.config;

import edu.bsu.shop.model.User;
import lombok.Data;

@Data
public class ViewConfig {
    private static final ViewConfig INSTANCE = new ViewConfig();
    private User user;
    private ViewConfig(){}

    public static ViewConfig getInstance() {
        return INSTANCE;
    }
}
