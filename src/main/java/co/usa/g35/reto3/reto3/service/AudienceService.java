package co.usa.g35.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Audience;
import co.usa.g35.reto3.reto3.repository.AudienceRepository;

@Service
public class AudienceService {
    @Autowired

    AudienceRepository auditorioRepository;

    public List<Audience> getAll() {

        return auditorioRepository.getAll();
    }

    public Optional<Audience> getAudit(int id) {
        return auditorioRepository.getAudit(id);
    }

    public Audience save(Audience audit) {
        // Verificar si el Id viene Null
        if (audit.getId() == null) {
            return auditorioRepository.save(audit);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Audience> consulta = auditorioRepository.getAudit(audit.getId());
            if (consulta.isEmpty()) {
                return auditorioRepository.save(audit);
            } else {
                return audit;
            }
        }

    }

    public Audience update(Audience audit) {

        if (audit.getId() != null) {
            Optional<Audience> consulta = auditorioRepository.getAudit(audit.getId());
            if (!consulta.isEmpty()) {
                if (audit.getName() != null) {
                    consulta.get().setName(audit.getName());
                }
                if (audit.getOwner() != null)
                    consulta.get().setOwner(audit.getOwner());
                if (audit.getCapacity()!= null) {
                    consulta.get().setCapacity(audit.getCapacity());
                }
                if (audit.getDescription()!= null) {
                    consulta.get().setDescription(audit.getDescription());
                }
            }

            return auditorioRepository.save(consulta.get());
        }

        return audit;
    }

    public boolean deleteAudit(int id){
        Optional<Audience> consulta = auditorioRepository.getAudit(id);
        if (!consulta.isEmpty()) {
            auditorioRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
}
