package edu.bsu.eco.service;

import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceInputDto;
import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceOutputDto;

import java.util.List;

public interface TrashSeparatingPlaceService {

    TrashSeparatingPlaceOutputDto save(TrashSeparatingPlaceInputDto dto);

    TrashSeparatingPlaceOutputDto findById(long id);

    List<TrashSeparatingPlaceOutputDto> findAll();

    void deleteById(long id);

    void deleteAll();
}
