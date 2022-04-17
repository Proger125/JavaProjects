package edu.bsu.eco.dao;

import edu.bsu.eco.entity.TrashType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrashTypeDao extends JpaRepository<TrashType, Long> {

    Optional<TrashType> findFirstByName(String name);
}
