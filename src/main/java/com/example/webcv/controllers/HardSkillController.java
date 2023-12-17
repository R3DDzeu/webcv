package com.example.webcv.controllers;

import com.example.webcv.models.Entities.HardSkill;
import com.example.webcv.services.HardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hardskills")
public class HardSkillController {

    private final HardSkillService hardSkillService;

    @Autowired
    public HardSkillController(HardSkillService hardSkillService) {
        this.hardSkillService = hardSkillService;
    }

    @PostMapping
    public ResponseEntity<HardSkill> createHardSkill(@RequestBody HardSkill hardSkill) {
        return ResponseEntity.ok(hardSkillService.saveOrUpdateHardSkill(hardSkill));
    }

    @GetMapping
    public List<HardSkill> getAllHardSkills() {
        return hardSkillService.getAllHardSkills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardSkill> getHardSkillById(@PathVariable Long id) {
        return hardSkillService.getHardSkillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardSkill> updateHardSkill(@PathVariable Long id, @RequestBody HardSkill hardSkill) {
        return ResponseEntity.ok(hardSkillService.saveOrUpdateHardSkill(hardSkill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardSkill(@PathVariable Long id) {
        hardSkillService.deleteHardSkillById(id);
        return ResponseEntity.ok().build();
    }
}
