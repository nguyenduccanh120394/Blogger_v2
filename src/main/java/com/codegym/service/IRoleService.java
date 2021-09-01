package com.codegym.service;
import com.codegym.model.*;
import com.codegym.service.*;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
