package account.component;


import account.model.Role;
import account.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

@Component
@Slf4j
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup;
    RoleRepository roleRepository;

    Set<String> roleList;

    @Autowired
    public SetupDataLoader(RoleRepository roleRepository, Set<String> roleList) {
        this.alreadySetup = false;
        this.roleRepository = roleRepository;
        this.roleList = roleList;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Setup role");
        if (alreadySetup) return;
        for (String role : roleList) {
            createRoleIfNotFound(role);
        }
        roleRepository.findAll().forEach(role -> System.out.println(role.getName()));
        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setName(name);
            roleRepository.save(role);
        }
        return role;
    }
}