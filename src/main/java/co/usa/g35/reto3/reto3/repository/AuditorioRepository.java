package co.usa.g35.reto3.reto3.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g35.reto3.reto3.model.Auditorio;
import co.usa.g35.reto3.reto3.repository.crud.AuditorioCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuditorioRepository {
    @Autowired
    AuditorioCrudRepository auditorioCrudRepository;

    public List<Auditorio> getAll() {
        return (List<Auditorio>) auditorioCrudRepository.findAll();
    }

    public Optional<Auditorio> getAudit(int id) {
        return auditorioCrudRepository.findById(id);
    }

    public Auditorio save(Auditorio audit) {
        return auditorioCrudRepository.save(audit);
    }
}
