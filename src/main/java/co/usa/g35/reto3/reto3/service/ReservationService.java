package co.usa.g35.reto3.reto3.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Reservation;
import co.usa.g35.reto3.reto3.model.reportes.contClients;
import co.usa.g35.reto3.reto3.model.reportes.contReserStatus;
import co.usa.g35.reto3.reto3.repository.ReservationRespository;

@Service
public class ReservationService {
    @Autowired
    ReservationRespository reservationRespository;

    public List<Reservation> getAll() {

        return reservationRespository.getAll();
    }

    public Optional<Reservation> getReser(int id) {
        return reservationRespository.getReser(id);
    }

    public Reservation save(Reservation reservation) {
        // Verificar si el Id viene Null
        if (reservation.getIdReservation() == null) {
            return reservationRespository.save(reservation);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Reservation> consulta = reservationRespository.getReser(reservation.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRespository.save(reservation);
            } else {
                return reservation;
            }
        }

    }

    public Reservation update(Reservation reservation) {

        if (reservation.getIdReservation() != null) {
            Optional<Reservation> consulta = reservationRespository.getReser(reservation.getIdReservation());
            if (!consulta.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    consulta.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    consulta.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    consulta.get().setStatus(reservation.getStatus());
                }
            }

            return reservationRespository.save(consulta.get());
        }

        return reservation;
    }

    public boolean deleteReservation(int id){
        Optional<Reservation> consulta = reservationRespository.getReser(id);
        if (!consulta.isEmpty()) {
            reservationRespository.delete(consulta.get());
            return true;
        }
        return false;
    }

    public List<contClients> getTopClients(){
        return reservationRespository.getTopClients();
    }

    public contReserStatus getReserStatus(){
        List<Reservation> completed=reservationRespository.getReserByStatus("completed");
        List<Reservation> cancelled=reservationRespository.getReserByStatus("cancelled");
        contReserStatus reporteReser= new contReserStatus(completed.size(), cancelled.size());
        
        return reporteReser;
    }

    public List<Reservation> getReserFechas(String start, String Devolution){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        Date fechaIni=new Date();
        Date fechaFin = new Date();

        try {
            fechaFin=format.parse(start);
            fechaFin=format.parse(Devolution);
        } catch (ParseException e) {
            
            e.printStackTrace();
        }

        if (fechaIni.before(fechaFin)) {
            return reservationRespository.getReserFechas(fechaIni, fechaFin);
        }else{
            return new ArrayList<>();
        }
         
    }
}
