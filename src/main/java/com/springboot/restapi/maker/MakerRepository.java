package com.springboot.restapi.maker;


import com.springboot.restapi.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MakerRepository extends JpaRepository<Maker, Long> {



}