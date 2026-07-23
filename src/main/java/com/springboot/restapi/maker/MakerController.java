package com.springboot.restapi.maker;

import com.springboot.restapi.entity.Maker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/makers")
public class MakerController {

    private MakerService makerService;

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

    @PostMapping
    public ResponseEntity<Maker> save(@RequestBody Maker maker){
        Maker saved = makerService.save(maker);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}








