package co.usa.g35.reto3.reto3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Client;
import co.usa.g35.reto3.reto3.repository.ClientRepository;
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll() {

        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        // Verificar si el Id viene Null
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Client> consulta = clientRepository.getClient(client.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }

    }
}
