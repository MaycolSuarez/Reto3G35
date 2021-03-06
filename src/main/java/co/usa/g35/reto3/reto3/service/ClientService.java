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

    public Client update(Client client) {

        if (client.getIdClient() != null) {
            Optional<Client> consulta = clientRepository.getClient(client.getIdClient());
            if (!consulta.isEmpty()) {
                if (client.getName() != null) {
                    consulta.get().setName(client.getName());
                }
                if (client.getEmail() != null)
                    consulta.get().setEmail(client.getEmail());
                if (client.getPassword() != null) {
                    consulta.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    consulta.get().setAge(client.getAge());
                }
            }

            return clientRepository.save(consulta.get());
        }

        return client;
    }

    public boolean deleteClient(int id){
        Optional<Client> consulta = clientRepository.getClient(id);
        if (!consulta.isEmpty()) {
            clientRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
}
