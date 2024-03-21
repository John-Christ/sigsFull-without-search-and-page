package sigs.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;




    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private Module module;



    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id")
    private Permission permission;



    @JsonIgnore
    @ManyToMany(mappedBy = "assignedPrivileges", cascade = CascadeType.ALL)
    private Set<Role> roleSet = new HashSet<>();




    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }



    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }




    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }










}


