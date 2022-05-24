package edu.bsu.eco.dao;

import edu.bsu.eco.entity.TrashSeparatingPlace;
import edu.bsu.eco.entity.TrashType;

import java.util.List;
import java.util.Map;

public interface SpecialDao {

    List<TrashSeparatingPlace> findPlacesByParams(List<TrashType> trashTypes);
}
