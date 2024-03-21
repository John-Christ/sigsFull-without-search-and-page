package sigs.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    private String action;



  /*  @JsonIgnore
    @ManyToMany(mappedBy = "assignedPermissions")
    private Set<Role> roleSet = new HashSet<>();



    @ManyToMany
    @JoinTable(name = "permission_module",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private Set<Module> assignedModules = new HashSet<>();


*/

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    /*

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }




    public Set<Module> getAssignedModules() {
        return assignedModules;
    }

    public void setAssignedModules(Set<Module> assignedModules) {
        this.assignedModules = assignedModules;
    }


*/




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





}

