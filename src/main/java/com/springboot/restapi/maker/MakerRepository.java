package com.springboot.restapi.maker;


import com.springboot.restapi.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakerRepository extends JpaRepository<Maker, Long> {
}