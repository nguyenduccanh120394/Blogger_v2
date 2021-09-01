package com.codegym.service.iplm;
import com.codegym.model.*;
import com.codegym.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.repository.*;
import java.util.Optional;
@Service
public class RoleServiceIplm implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
