package com.springboot.restapi.maker;

import com.springboot.restapi.entity.Maker;

import java.util.List;
import java.util.Optional;

public interface MakerService {

    List<Maker> findAll();

    Optional<Maker> findById(Long id);

    Maker save(Maker maker);

    void deleteById(Long id);
}
