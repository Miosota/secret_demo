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

    @Column(name = "secret_text")
    private String secretText;

    @Column(name = "times_to_view")
    private int timesToView;

    public Secret(
            User user, 
            String secretText,
            int timesToView){
        this.user = user;
        this.secretText = secretText;
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

    public void setSecretText (String secretText) {
        this.secretText = secretText;
    }

    public void setTimesToView (int timesToView) {
        this.timesToView = timesToView;
    }

      //getters

      public Long getId(){
        return id;
    }
}
