package org.secretproject.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Secret> secretList = new ArrayList<>();

    public User (String name) {
        this.name = name;
    }

    public User () {
      
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecrets(List<Secret> secretList){
        this.secretList.addAll(secretList);
    }

    //getters

    public Long getId(){
        return id;
    }


}
