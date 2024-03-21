package sigs.api.web;


import java.util.List;

import sigs.api.model.Permission;
import sigs.api.model.Privilege;
import sigs.api.repository.PrivilegeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sigs.api.exception.RestApiNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

//@CrossOrigin("http://localhost:4200")
@Controller
@RequestMapping("/privilege")
@RestController
public class PrivilegeController
{


    private final PrivilegeRepository repository;
    PrivilegeController(PrivilegeRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<Privilege> all() {
        return (List<Privilege>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping
    Privilege newPrivilege(@Valid @RequestBody Privilege newPrivilege) {
        return repository.save(newPrivilege);
    }

    // Single item

    @GetMapping("/{id}")
    Privilege one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/{id}")
    Privilege replacePrivilege(@Valid @RequestBody Privilege newPrivilege, @PathVariable Long id) {

        return repository.findById(id)
                .map(privilege -> {
                    privilege.setPermission(newPrivilege.getPermission());
                    privilege.setModule(newPrivilege.getModule());
                    privilege.setRoleSet(newPrivilege.getRoleSet());


                    return repository.save(privilege);
                })
                .orElseGet(() -> {
                    newPrivilege.setId(id);
                    return repository.save(newPrivilege);
                });
    }

    @DeleteMapping("/{id}")
    void deletePrivilege(@PathVariable Long id) {
        repository.deleteById(id);
    }






}

