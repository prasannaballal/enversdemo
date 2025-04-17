package com.example.envers.enversdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnversController {

    @Autowired
    EnversService enversService;

    @PostMapping("/envers")
    public ResponseEntity<String> createPerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(enversService.createPerson(personDto));
    }

    @PutMapping("/envers")
    public ResponseEntity<String> updatePerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(enversService.updatePerson(personDto));
    }

    @DeleteMapping("/envers/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        return ResponseEntity.ok(enversService.deletePerson(id));
    }
}
