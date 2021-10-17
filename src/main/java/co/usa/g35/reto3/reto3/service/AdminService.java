package co.usa.g35.reto3.reto3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Admin;
import co.usa.g35.reto3.reto3.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {

        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        // Verificar si el Id viene Null
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Admin> consulta = adminRepository.getAdmin(admin.getIdAdmin());
            if (consulta.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }

    }

}
