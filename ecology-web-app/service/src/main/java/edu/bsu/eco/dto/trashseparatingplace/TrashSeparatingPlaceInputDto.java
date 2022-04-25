package edu.bsu.eco.dto.trashseparatingplace;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
public class TrashSeparatingPlaceInputDto {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String address;

    @Positive
    @Max(90)
    private double latitude;

    @Positive
    @Max(180)
    private double longitude;

    @NotNull
    private String phoneNumber;

    @Pattern(regexp = "((1[0-9])|(2[0-4])|([1-9])):[0-5][0-9]-((1[0-9])|(2[0-4])|([1-9])):[0-5][0-9]")
    private String workingHours;

    @NotNull
    List<String> trashTypes;
}
