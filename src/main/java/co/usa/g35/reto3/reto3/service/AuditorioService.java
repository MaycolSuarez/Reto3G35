package co.usa.g35.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Auditorio;
import co.usa.g35.reto3.reto3.repository.AuditorioRepository;

@Service
public class AuditorioService {
    @Autowired

    AuditorioRepository auditorioRepository;

    public List<Auditorio> getAll() {

        return auditorioRepository.getAll();
    }

    public Optional<Auditorio> getAudit(int id) {
        return auditorioRepository.getAudit(id);
    }

    public Auditorio save(Auditorio audit) {
        // Verificar si el Id viene Null
        if (audit.getId() == null) {
            return auditorioRepository.save(audit);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Auditorio> consulta = auditorioRepository.getAudit(audit.getId());
            if (consulta.isEmpty()) {
                return auditorioRepository.save(audit);
            } else {
                return audit;
            }
        }

    }
}
