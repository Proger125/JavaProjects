package edu.bsu.eco.mapper;

import edu.bsu.eco.entity.TrashType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TrashTypeMapper {

    @Mapping(target = "name", expression = "java(trashType)")
    TrashType toTrashType(String trashType);
}
