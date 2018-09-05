package com.adamfeher.carshare.repository;

import com.adamfeher.carshare.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    public List<Travel> getAllByStartingPlace();
}
