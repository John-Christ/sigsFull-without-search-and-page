package sigs.api.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sigs.api.repository.RoleRepository;
import sigs.api.repository.UserDao;
import sigs.api.dao.DAOUser;
import sigs.api.dto.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Autowired
    private RoleRepository roleRepository;



    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;

       // Role hole = roleRepository.findByLabel(String label);

        DAOUser  user =  userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        String role = String.valueOf(user.getRole());
        roles = Arrays.asList(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), roles);



        //User(user.getUsername(), user.getPassword(), roles); new ArrayList<>()
    };







    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        newUser.setAssignedRoles(user.getAssignedRoles());
        newUser.setNom(user.getNom());
        newUser.setPrenom(user.getPrenom());
        newUser.setEmail(user.getEmail());
        newUser.setTel(user.getTel());
        return userDao.save(newUser);
    }
}