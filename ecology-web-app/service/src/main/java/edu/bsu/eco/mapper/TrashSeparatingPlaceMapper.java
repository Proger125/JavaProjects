package edu.bsu.eco.mapper;

import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceInputDto;
import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceOutputDto;
import edu.bsu.eco.entity.TrashSeparatingPlace;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {TrashTypeMapper.class})
@Component
public interface TrashSeparatingPlaceMapper {

    TrashSeparatingPlace toTrashSeparatingPlace(TrashSeparatingPlaceInputDto dto);

    TrashSeparatingPlaceOutputDto toTrashSeparatingPlaceOutputDto(TrashSeparatingPlace place);
}
