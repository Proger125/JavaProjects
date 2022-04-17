package edu.bsu.eco.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    private String errorMessage;

    private int errorCode;
}
