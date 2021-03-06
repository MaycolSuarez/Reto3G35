package co.usa.g35.reto3.reto3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Message;
import co.usa.g35.reto3.reto3.repository.MessageRepository;
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAll() {

        return messageRepository.getAll();
    }

    public Optional<Message> getMessa(int id) {
        return messageRepository.getMessa(id);
    }

    public Message save(Message messa) {
        // Verificar si el Id viene Null
        if (messa.getIdMessage() == null) {
            return messageRepository.save(messa);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Message> consulta = messageRepository.getMessa(messa.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepository.save(messa);
            } else {
                return messa;
            }
        }

    }

    public Message update(Message message) {

        if (message.getIdMessage() != null) {
            Optional<Message> consulta = messageRepository.getMessa(message.getIdMessage());
            if (!consulta.isEmpty()) {
                if (message.getMessageText() != null) {
                    consulta.get().setMessageText(message.getMessageText());
                }
            }

            return messageRepository.save(consulta.get());
        }

        return message;
    }

    public boolean deleteMessage(int id){
        Optional<Message> consulta = messageRepository.getMessa(id);
        if (!consulta.isEmpty()) {
            messageRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
}
