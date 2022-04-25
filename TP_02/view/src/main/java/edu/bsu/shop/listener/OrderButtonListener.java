package edu.bsu.shop.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsu.shop.model.Order;
import edu.bsu.shop.view.config.ViewConfig;
import edu.bsu.shop.view.panel.ClientPanel;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static edu.bsu.shop.view.config.GraphicalItems.MAIN_FRAME;
import static edu.bsu.shop.view.config.GraphicalItems.repaintFrame;

public class OrderButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder builder = new StringBuilder();
        DefaultListModel<String> defaultListModel = ViewConfig.getInstance().getBasketModel();
        for (int i = 0; i < defaultListModel.getSize(); i++) {
            builder.append(defaultListModel.getElementAt(i)).append("\n");
        }
        builder.append("Total cost: ").append(ViewConfig.getInstance().getTotalCost()).append("\n");
        builder.append("Create order?");
        String message = builder.toString();
        int result = JOptionPane.showConfirmDialog(null, message, "Order", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            if (ViewConfig.getInstance().getBasket().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Your basket is empty");
                return;
            }
            JSONArray jsonArray = new JSONArray(ViewConfig.getInstance().getBasket());
            JSONObject jsonObject = new JSONObject(ViewConfig.getInstance().getUser());
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody
                    .create(mediaType, "{\r\n\"totalCost\":" + ViewConfig.getInstance().getTotalCost() + ",\"products\":" + jsonArray + ", \"orderStatus\": \"IN_PROCESS\", \"user\":" + jsonObject + "}");
            Request request = new Request.Builder()
                    .url("http://localhost:8080/orders")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            try {
                ResponseBody responseBody = client.newCall(request).execute().body();
                ObjectMapper objectMapper = new ObjectMapper();
                if (responseBody != null) {
                    Order order = objectMapper.readValue(responseBody.string(), Order.class);
                    JOptionPane.showMessageDialog(null, order.getTotalCost() + "\n" + order.getProducts());
                    MAIN_FRAME.setContentPane(new ClientPanel());
                    repaintFrame();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong...", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
