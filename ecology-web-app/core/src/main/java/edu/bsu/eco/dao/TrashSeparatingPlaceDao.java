package edu.bsu.eco.dao;

import edu.bsu.eco.entity.TrashSeparatingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashSeparatingPlaceDao extends JpaRepository<TrashSeparatingPlace, Long> {
}
