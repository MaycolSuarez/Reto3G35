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
}
