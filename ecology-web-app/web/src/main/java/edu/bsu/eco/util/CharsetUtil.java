package edu.bsu.eco.util;

import edu.bsu.eco.errorhandler.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CharsetUtil {

    public void changeExceptionResponseCharset(ResponseEntity<ErrorMessage> responseEntity){
        HttpHeaders httpHeaders = HttpHeaders.writableHttpHeaders(responseEntity.getHeaders());
        httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
    }
}
