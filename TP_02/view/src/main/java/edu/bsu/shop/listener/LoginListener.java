package edu.bsu.shop.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsu.shop.model.User;
import edu.bsu.shop.view.config.ViewConfig;
import edu.bsu.shop.view.panel.AccountantPanel;
import edu.bsu.shop.view.panel.ClientPanel;
import edu.bsu.shop.view.panel.ManagerPanel;
import okhttp3.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static edu.bsu.shop.view.config.GraphicalItems.*;

public class LoginListener implements ActionListener {
    private static final LoginListener INSTANCE = new LoginListener();

    private static final String SERVER_URL = "http://localhost:8080/login";
    private static final String CLIENT_ROLE = "CLIENT";
    private static final String MANAGER_ROLE = "MANAGER";

    @Override
    public void actionPerformed(ActionEvent e) {
        String login = LOGIN_FIELD.getText();
        String password = new String(PASSWORD_FIELD.getPassword());

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"login\": \"" + login + "\",\r\n    \"password\": \"" + password +"\"\r\n}");
        Request request = new Request.Builder()
                .url(SERVER_URL)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            if (responseBody != null) {
                ViewConfig.getInstance().setUser(objectMapper.readValue(responseBody.string(), User.class));
                System.out.println(ViewConfig.getInstance().getUser().getId());
                User user = ViewConfig.getInstance().getUser();
                if (user.getRole().equals(CLIENT_ROLE)) {
                    MAIN_FRAME.setContentPane(new ClientPanel());
                } else if (user.getRole().equals(MANAGER_ROLE)) {
                    MAIN_FRAME.setContentPane(new ManagerPanel());
                } else {
                    MAIN_FRAME.setContentPane(new AccountantPanel());
                }

                repaintFrame();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private LoginListener() {}

    public static LoginListener getInstance() {
        return INSTANCE;
    }
}
