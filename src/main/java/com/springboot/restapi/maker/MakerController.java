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
        return ResponseEntity.status(HttpStatus.CREATED).body(maker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maker> update(@PathVariable Long id,
                                        @RequestBody Maker maker) {

        return makerService.findById(id)
                .map(existing -> {
                    existing.setName(maker.getName());
                    Maker updated = makerService.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (makerService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        makerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}









