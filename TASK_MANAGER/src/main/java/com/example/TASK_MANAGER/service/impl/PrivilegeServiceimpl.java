package com.example.TASK_MANAGER.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TASK_MANAGER.entity.Privilege;
import com.example.TASK_MANAGER.repository.PrivilegeRepo;
import com.example.TASK_MANAGER.repository.RoleRepo;
import com.example.TASK_MANAGER.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    private final PrivilegeRepo privilegeRepo;
    private final RoleRepo roleRepo;

    public PrivilegeServiceImpl(PrivilegeRepo privilegeRepo, RoleRepo roleRepo) {
        this.privilegeRepo = privilegeRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public Privilege createPrivilege(Privilege privilege) {
        if (privilegeRepo.existsByName(privilege.getName())) {
            throw new RuntimeException("privilege already exists");
        }
        return privilegeRepo.save(privilege);
    }

    @Override
    public List<Privilege> getAllPrivileges() {
        return privilegeRepo.findAll();
    }

    @Override
    public Privilege updatePrivilege(Long id, Privilege updatedPrivilege) {
        Privilege privilege = privilegeRepo.findById(id).orElseThrow(() -> new RuntimeException("privilege not found"));

        privilege.setName(updatedPrivilege.getName());
        privilege.setDescription(updatedPrivilege.getDescription());

        return privilegeRepo.save(privilege);
    }
    @Override
    public void deletePrivilege(Long id) {
    	Privilege privilege=PrivilegeRepo.findById(id).orElseThrow(()->new RuntimeException("Privilege not found"));
    	if(!privilege.getRoles().isEmpty()) {
    		throw new RuntimeException("privilege Assigned to roles ");
    		
    	}
    	privilegeRepo.delete(privilege);
    	
    }
    @Override
    public void assignprivilegeToRole(Long privilegeid,Long Roleid) {
    	Privilege privilege=privilegeRepo.findById(privilegeid).orElseThrow(()->new RuntimeException("RolenotFound"));
    	Role role=roleRepo.findById(role id).orElseThrow(()-> new RuntimeException("Role not Found"));
    	role.getPrivileges().add(privilege);
    	roleRepo.save(role);
    	
    }
}
