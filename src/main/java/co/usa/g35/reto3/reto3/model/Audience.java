package co.usa.g35.reto3.reto3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//se importa JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Se maraca la aclse como entidad
@Entity
//Nombre del nombre d ela tabla en base de datos
@Table(name = "audience")
/**
 * Clase audience
 * @author Maycol
 */
public class Audience implements Serializable {
    //atributo id Vatiable autoincremental y unica
    @Id
    //atributo id Vatiable autoincremental y unica
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //atributo id
    private Integer id;
    //atributo name Variable String
    private String name;
    //atributo owner Variable String
    private String owner;
    //atributo capacity Variable Integer
    private Integer capacity;
    //atributo description Variable String
    private String description;
    //Relacion muchos a uno
    @ManyToOne
    //columna de llave foranea
    @JoinColumn(name = "category")
    //Ignore properties para evitar ciclos infinitos de llamados
    @JsonIgnoreProperties("audiences")
    //Atrubuto category de tipo category
    private Category category;
    
    
    //Relacion uno muchos
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "audience")
    //Ignore properties para evitar ciclos infinitos de llamados
    @JsonIgnoreProperties({"audience","client"})
    //atributo messages Vatiable de tipo List<Message>
    private List<Message> messages;

    //Relacion uno muchos
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "audience")
    //Ignore properties para evitar ciclos infinitos de llamados
    @JsonIgnoreProperties({"audience","message"})
    //atributo Reservations Vatiable de tipo List<Reservation> 
    private List<Reservation> reservations;


    //Inicio de getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

}
