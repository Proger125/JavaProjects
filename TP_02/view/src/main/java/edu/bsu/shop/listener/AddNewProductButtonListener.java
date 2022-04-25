package edu.bsu.shop.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsu.shop.model.Product;
import okhttp3.*;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;

import static edu.bsu.shop.view.config.GraphicalItems.*;

public class AddNewProductButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Product product = new Product();
        product.setName(PRODUCT_NAME_FIELD.getText());
        product.setDescription(PRODUCT_DESCRIPTION_AREA.getText());
        product.setCost(new BigDecimal(PRODUCT_COST_FIELD.getText()));
        JSONObject object = new JSONObject(product);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, object.toString());
        Request request = new Request.Builder()
                .url("http://localhost:8080/products")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            ObjectMapper mapper = new ObjectMapper();
            if (responseBody != null) {
                Product responseProduct = mapper.readValue(responseBody.string(), Product.class);
                JOptionPane.showMessageDialog(null, responseProduct, "Product was successfully added", JOptionPane.PLAIN_MESSAGE);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
