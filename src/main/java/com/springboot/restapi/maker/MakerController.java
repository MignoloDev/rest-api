package com.springboot.restapi.maker;

import com.springboot.restapi.entity.Maker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/makers")
public class MakerController {

    private final MakerService makerService;

    public MakerController(MakerService makerService){
        this.makerService = makerService;
    }

    @GetMapping
    public List<Maker> findAll(){
        return makerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maker> findById(@PathVariable Long id){
        return makerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}





