package edu.bsu.shop.listener;

import edu.bsu.shop.model.Order;
import edu.bsu.shop.view.config.ViewConfig;
import edu.bsu.shop.view.panel.AccountantPanel;
import edu.bsu.shop.view.panel.ManagerPanel;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static edu.bsu.shop.view.config.GraphicalItems.MAIN_FRAME;
import static edu.bsu.shop.view.config.GraphicalItems.repaintFrame;

@RequiredArgsConstructor
public class ChangeOrderStatusListener implements ActionListener {

    private final String newStatus;

    private final Order order;

    @Override
    public void actionPerformed(ActionEvent e) {
        order.setOrderStatus(newStatus);
        JSONArray jsonArray = new JSONArray(order.getProducts());
        JSONObject jsonObject = new JSONObject(order.getUser());
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"id\":" + order.getId() + ",\r\n    \"totalCost\":" + order.getTotalCost() + ",\r\n    \"products\":" + jsonArray + ",\r\n    \"orderStatus\": \"" + order.getOrderStatus() + "\",\"user\":" + jsonObject +"}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/orders")
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            if (responseBody != null) {
                JOptionPane.showMessageDialog(null, "Status was successfully changed!");
                String userRole = ViewConfig.getInstance().getUser().getRole();
                if (userRole.equals("MANAGER")) {
                    MAIN_FRAME.setContentPane(new ManagerPanel());
                } else if (userRole.equals("ACCOUNTANT")) {
                    MAIN_FRAME.setContentPane(new AccountantPanel());
                }

                repaintFrame();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
