package co.usa.g35.reto3.reto3.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.g35.reto3.reto3.model.Auditorio;
import co.usa.g35.reto3.reto3.service.AuditorioService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class AuditorioController {

    @Autowired
    private AuditorioService auditorioService;

    @GetMapping("/all")
    public List<Auditorio> getAuditorios() {
        return auditorioService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Auditorio> getAudit(@PathVariable("id") int id) {
        return auditorioService.getAudit(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio save(@RequestBody Auditorio audit) {
        return auditorioService.save(audit);
    }
    
}
