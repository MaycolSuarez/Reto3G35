package co.usa.g35.reto3.reto3.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g35.reto3.reto3.model.Message;
import co.usa.g35.reto3.reto3.repository.crud.MessageCrudRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class MessageRepository {
    @Autowired
    MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessa(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message save(Message messa) {
        return messageCrudRepository.save(messa);
    }

    public void delete(Message category){
        messageCrudRepository.delete(category);
    }
}
