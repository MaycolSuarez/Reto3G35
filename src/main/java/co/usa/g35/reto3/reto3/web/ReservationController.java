package co.usa.g35.reto3.reto3.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.g35.reto3.reto3.model.Reservation;
import co.usa.g35.reto3.reto3.model.reportes.contClients;
import co.usa.g35.reto3.reto3.model.reportes.contReserStatus;
import co.usa.g35.reto3.reto3.service.ReservationService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReser(@PathVariable("id") int id) {
        return reservationService.getReser(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation category) {
        return reservationService.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteAudit(@PathVariable("id") int id) {
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-status")
    public contReserStatus getReserStatus(){
        return reservationService.getReserStatus();
    }

    @GetMapping("/report-clients")
    public List<contClients> getReportClients(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{startDate}/{devolDate}")
    public List<Reservation> getReserFechas(@PathVariable("startDate") String start,@PathVariable("devolDate") String devol){
        return reservationService.getReserFechas(start, devol);
    }
}
