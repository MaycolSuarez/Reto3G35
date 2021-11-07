package co.usa.g35.reto3.reto3.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usa.g35.reto3.reto3.model.Reservation;

public interface ReservationCrudRepository extends
CrudRepository<Reservation,Integer> {

    //JPQL
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client)DESC")

    public List<Object[]> countTotalClientsByReservation();

    //query methods
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date startDate, Date DevolutionDate);

    public List<Reservation> findAllByStatus(String status);
}
