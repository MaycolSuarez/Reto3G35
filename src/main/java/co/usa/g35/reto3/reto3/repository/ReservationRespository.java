package co.usa.g35.reto3.reto3.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g35.reto3.reto3.model.Client;
import co.usa.g35.reto3.reto3.model.Reservation;
import co.usa.g35.reto3.reto3.model.reportes.contClients;
import co.usa.g35.reto3.reto3.repository.crud.ReservationCrudRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public class ReservationRespository {
    @Autowired
    ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReser(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation category){
        reservationCrudRepository.delete(category);
    }

    public List<Reservation> getReserByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReserFechas(Date start, Date Devolution){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(start, Devolution);
    }

    public List<contClients> getTopClients(){
        List<contClients> result=new ArrayList<>();
        List <Object[]> reporte=reservationCrudRepository.countTotalClientsByReservation();
        
        for (int i = 0; i < reporte.size(); i++) {
            result.add(new contClients((Long)reporte.get(i)[1], (Client)reporte.get(i)[0]));
        }

        return result;
    }

}
