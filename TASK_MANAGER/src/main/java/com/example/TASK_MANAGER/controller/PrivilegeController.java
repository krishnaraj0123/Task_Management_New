package com.example.TASK_MANAGER.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TASK_MANAGER.entity.Privilege;
import com.example.TASK_MANAGER.service.PrivilegeService;

@RestController
@RequestMapping("/api/privileges")
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    @PostMapping
    public ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privilege) {
        return ResponseEntity.ok(privilegeService.createPrivilege(privilege));
    }

    @GetMapping
    public ResponseEntity<List<Privilege>> getAllPrivileges() {
        return ResponseEntity.ok(privilegeService.getAllPrivileges());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrivilege(@PathVariable Long id) {
        privilegeService.deletePrivilege(id);
        return ResponseEntity.ok("Privilege deleted successfully");
    }
}
