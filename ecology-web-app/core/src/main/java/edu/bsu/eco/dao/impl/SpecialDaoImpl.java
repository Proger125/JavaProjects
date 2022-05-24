package edu.bsu.eco.dao.impl;

import edu.bsu.eco.dao.SpecialDao;
import edu.bsu.eco.entity.TrashSeparatingPlace;
import edu.bsu.eco.entity.TrashType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SpecialDaoImpl implements SpecialDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<TrashSeparatingPlace> findPlacesByParams(List<TrashType> trashTypes) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TrashSeparatingPlace> criteriaQuery = criteriaBuilder.createQuery(TrashSeparatingPlace.class);

        Root<TrashSeparatingPlace> root = criteriaQuery.from(TrashSeparatingPlace.class);
        List<Predicate> predicates = new ArrayList<>();
        for (var trashType : trashTypes) {
            predicates.add(criteriaBuilder.isMember(trashType, root.get("trashTypes")));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
