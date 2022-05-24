package edu.bsu.eco.controller;

import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceInputDto;
import edu.bsu.eco.dto.trashseparatingplace.TrashSeparatingPlaceOutputDto;
import edu.bsu.eco.service.TrashSeparatingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trash-separating-places")
@CrossOrigin(origins = "http://localhost:3000")
public class TrashSeparatingPlaceController {

    private final TrashSeparatingPlaceService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrashSeparatingPlaceOutputDto save(@Valid @RequestBody TrashSeparatingPlaceInputDto dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrashSeparatingPlaceOutputDto findById(@PathVariable @Positive long id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrashSeparatingPlaceOutputDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable @Positive long id) {
        service.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping("/params")
    @ResponseStatus(HttpStatus.OK)
    public List<TrashSeparatingPlaceOutputDto> findPlacesByParams(@RequestParam List<String> trashTypes) {
        return service.findPlacesByParams(trashTypes);
    }

}
