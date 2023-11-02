package com.backend.controller;

import com.backend.entity.Checkbook;
import com.backend.service.CheckbookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckbookController {

    private final CheckbookService checkbookService;

    public CheckbookController(CheckbookService checkbookService) {
        this.checkbookService = checkbookService;
    }

    @GetMapping("/admin/checkbook")
    public List<Checkbook> getAll(){
        return checkbookService.getAllCheckbookRequests();
    }

    @PutMapping("/admin/checkbook/approve/{id}")
    public ResponseEntity<Checkbook> approveCheckbookStatus(@PathVariable Long id) {
        Checkbook updatedCheckbook = checkbookService.approveStatus(id);
        return ResponseEntity.ok(updatedCheckbook);
    }

    @PutMapping("/admin/checkbook/deny/{id}")
    public ResponseEntity<Checkbook> denyCheckbookStatus(@PathVariable Long id) {
        Checkbook updatedCheckbook = checkbookService.denyStatus(id);
        return ResponseEntity.ok(updatedCheckbook);
    }

    @PostMapping("/user/checkbook")
    public ResponseEntity<Checkbook> createCheckbook() {
        Checkbook createdCheckbook = checkbookService.createCheckbookRequest();
        return ResponseEntity.ok(createdCheckbook);
    }

}
