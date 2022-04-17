package edu.bsu.eco.errorhandler;

import edu.bsu.eco.exception.ResourceNotFoundException;
import edu.bsu.eco.translator.Translator;
import edu.bsu.eco.util.CharsetUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class EcoErrorHandler {

    private static final String RESOURCE_NOT_FOUND_MESSAGE = "error.message.resource_not_found";

    private final Translator translator;
    private final CharsetUtil charsetUtil;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException() {
        String messageText = translator.toLocale(RESOURCE_NOT_FOUND_MESSAGE);
        ErrorMessage message = new ErrorMessage(messageText, HttpStatus.NOT_FOUND.value());
        ResponseEntity<ErrorMessage> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        charsetUtil.changeExceptionResponseCharset(response);
        return response;
    }
}
