package co.usa.g35.reto3.reto3.model.reportes;

import co.usa.g35.reto3.reto3.model.Client;
//import co.usa.g35.reto3.reto3.model.Reservation;

public class contClients {
    private Long total;
    private Client client;

    

    public contClients(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    

    

    
}
