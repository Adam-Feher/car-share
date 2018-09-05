package com.adamfeher.carshare.controller;

import com.adamfeher.carshare.model.Position;
import com.adamfeher.carshare.model.Travel;
import com.adamfeher.carshare.repository.TravelRepository;
import com.adamfeher.carshare.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "travel/")
public class TravelController {
    private final TravelService travelService;
    private final TravelRepository travelRepository;

    @Autowired
    public TravelController(TravelService travelService, TravelRepository travelRepository) {
        this.travelService = travelService;
        this.travelRepository = travelRepository;
    }

    @GetMapping(value = "/near/{distance}&{latitude}&{longitude}")
    public List<Travel> getNearTravels(@PathVariable("distance") Integer distance, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
        List<Travel> allTravels = travelRepository.findAll();
        Position currentPos = new Position(longitude, latitude);
        return allTravels.stream()
                .filter(travel -> travelService.calcDistance(travel, currentPos) <= distance)
                .collect(Collectors.toList());
    }
}
