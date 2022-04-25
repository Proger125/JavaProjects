package edu.bsu.eco.dto.trashseparatingplace;

import edu.bsu.eco.entity.TrashType;
import lombok.Data;

import java.util.List;

@Data
public class TrashSeparatingPlaceOutputDto {

    private Long id;

    private String name;

    private String description;

    private String address;

    private double latitude;

    private double longitude;

    private String workingHours;

    private String phoneNumber;

    List<TrashType> trashTypes;
}
