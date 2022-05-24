package edu.bsu.eco.service.impl;

import edu.bsu.eco.dao.SpecialDao;
import edu.bsu.eco.dao.TrashSeparatingPlaceDao;
import edu.bsu.eco.dao.TrashTypeDao;
import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceInputDto;
import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceOutputDto;
import edu.bsu.eco.entity.TrashSeparatingPlace;
import edu.bsu.eco.entity.TrashType;
import edu.bsu.eco.exception.ResourceNotFoundException;
import edu.bsu.eco.mapper.TrashSeparatingPlaceMapper;
import edu.bsu.eco.mapper.TrashTypeMapper;
import edu.bsu.eco.service.TrashSeparatingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TrashSeparatingPlaceServiceImpl implements TrashSeparatingPlaceService {

    private final TrashSeparatingPlaceDao dao;

    private final SpecialDao specialDao;

    private final TrashTypeDao trashTypeDao;

    private final TrashSeparatingPlaceMapper mapper;

    private final TrashTypeMapper trashTypeMapper;

    @Override
    @Transactional
    public TrashSeparatingPlaceOutputDto save(TrashSeparatingPlaceInputDto dto) {
        TrashSeparatingPlace place = mapper.toTrashSeparatingPlace(dto);
        place.getTrashTypes().forEach(trashType -> {
            TrashType type = trashTypeDao.findFirstByName(trashType.getName()).orElseThrow(ResourceNotFoundException::new);
            trashType.setId(type.getId());
        });
        return mapper.toTrashSeparatingPlaceOutputDto(dao.save(place));
    }

    @Override
    public TrashSeparatingPlaceOutputDto findById(long id) {
        return mapper.toTrashSeparatingPlaceOutputDto(dao.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public List<TrashSeparatingPlaceOutputDto> findAll() {
        return dao.findAll().stream()
                .map(mapper::toTrashSeparatingPlaceOutputDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        dao.findById(id).orElseThrow(ResourceNotFoundException::new);
        dao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public List<TrashSeparatingPlaceOutputDto> findPlacesByParams(List<String> trashTypes) {
        List<TrashType> types = trashTypes.stream()
                .map(trashTypeMapper::toTrashType)
                .collect(Collectors.toList());
        types.forEach(trashType -> {
            TrashType type = trashTypeDao.findFirstByName(trashType.getName()).orElseThrow(ResourceNotFoundException::new);
            trashType.setId(type.getId());
        });
        return specialDao.findPlacesByParams(types)
                .stream()
                .map(mapper::toTrashSeparatingPlaceOutputDto)
                .collect(Collectors.toList());
    }
}
