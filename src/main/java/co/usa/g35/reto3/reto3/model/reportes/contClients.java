package co.usa.g35.reto3.reto3.model.reportes;

import co.usa.g35.reto3.reto3.model.Reservation;

public class contClients {
    private Long total;
    private Reservation reservation;

    public contClients(Long total, Reservation reservation) {
        this.total = total;
        this.reservation = reservation;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    

    
}
