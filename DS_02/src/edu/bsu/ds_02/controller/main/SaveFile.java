package edu.bsu.ds_02.controller.main;

import com.google.gson.Gson;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public interface SaveFile {
    default boolean saveFile(Users users, String fileName){
        Gson gson = new Gson();
        String maleJson = gson.toJson(users.getMales());
        String femaleJson = gson.toJson(users.getFemales());
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(maleJson);
            writer.write(femaleJson);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }
}
