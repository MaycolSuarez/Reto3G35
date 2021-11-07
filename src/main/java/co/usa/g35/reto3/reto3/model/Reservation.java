package co.usa.g35.reto3.reto3.model;

import java.io.Serializable;
import java.util.Date;
//import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "audience")
    @JsonIgnoreProperties("reservations")
    private Audience audience;

 

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    // @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "reservation")
    // @JsonIgnoreProperties("reservation")
    // private List<Score> scores;

    private Integer score;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    

}
