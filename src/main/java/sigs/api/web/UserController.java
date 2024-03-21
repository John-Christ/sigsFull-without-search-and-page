package sigs.api.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import sigs.api.dao.DAOUser;
//import sigs.api.service.UserService;


import sigs.api.dto.UserDTO;
import sigs.api.repository.DaoUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sigs.api.exception.RestApiNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import sigs.api.repository.UserDao;
import sigs.api.service.JwtUserDetailsService;

import javax.validation.Valid;


//@CrossOrigin("http://localhost:4200")
@Controller
@RequestMapping("/user")
@RestController
public class UserController
{


    @Autowired
    private UserDao userDao;



    @Autowired
    private JwtUserDetailsService userDetailsService;


    private final DaoUser repository;

    UserController(DaoUser repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<DAOUser> all() {
        return (List<DAOUser>) repository.findAll();
    }
    // end::get-aggregate-root[]

  /*  @PostMapping("/user-add")
    DAOUser newUser(@RequestBody DAOUser newUser) {
        return repository.save(newUser);
    }  */


    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<?> newUser(@Valid @RequestBody UserDTO user, BindingResult bindingResult, Model model) throws Exception {


        if (bindingResult.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.employee", bindingResult);
        }

        return ResponseEntity.ok(userDetailsService.save(user));
    }
    
    // Single item

    @GetMapping("/{id}")
    DAOUser one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }





    @PutMapping("/{id}")
    DAOUser replaceUser(@Valid @RequestBody DAOUser newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setNom(newUser.getNom());
                    user.setPrenom(newUser.getPrenom());
                    user.setEmail(newUser.getEmail());
                    user.setTel(newUser.getTel());
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setAssignedRoles(newUser.getAssignedRoles());
                    user.setRole(newUser.getRole());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }






    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<?> getUser() throws Exception {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        return  ResponseEntity.ok(userDao.findByUsername(username));
    }



}

