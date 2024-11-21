package org.secretproject.model;

// import javax.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "secrets")
public class Secret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "secret_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "secret_login")
    private String secretLogin;

    @Column(name = "secret_password")
    private String secretPassword;

    @Column(name = "times_to_view")
    private int timesToView;

    public Secret(
            User user, 
            String secretLogin, 
            String secretPassword,
            int timesToView){
        this.user = user;
        this.secretLogin = secretLogin;
        this.secretPassword = secretPassword;
        this.timesToView = timesToView;
    }

    public Secret(){
      
    }


    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSecretPassword (String secretLogin) {
        this.secretLogin = secretLogin;
    }

    public void setSecretLogin (String secretPassword) {
        this.secretPassword = secretPassword;
    }

    public void setTimesToView (int timesToView) {
        this.timesToView = timesToView;
    }

      //getters

      public Long getId(){
        return id;
    }
}
