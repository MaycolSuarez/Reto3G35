package co.usa.g35.reto3.reto3.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g35.reto3.reto3.model.Audience;
import co.usa.g35.reto3.reto3.repository.crud.AudienceCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AudienceRepository {
    @Autowired
    AudienceCrudRepository auditorioCrudRepository;

    public List<Audience> getAll() {
        return (List<Audience>) auditorioCrudRepository.findAll();
    }

    public Optional<Audience> getAudit(int id) {
        return auditorioCrudRepository.findById(id);
    }

    public Audience save(Audience audit) {
        return auditorioCrudRepository.save(audit);
    }
}
