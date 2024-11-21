package org.secretproject.model;

// import javax.persistence.*;

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

    //getters

    public Long getId(){
        return id;
    }


}
