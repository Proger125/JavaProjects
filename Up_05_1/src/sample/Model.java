package sample;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Model {
    private final Map<String, String> map;
    public Model(){
        map = new HashMap<>();
    }
    public void addElement(String value, String regex){
        map.put(value, regex);
    }
    public Pattern getRegularExpresion(String key){
        return Pattern.compile(map.get(key));
    }
}
