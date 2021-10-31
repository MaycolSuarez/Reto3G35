package co.usa.g35.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Category;
import co.usa.g35.reto3.reto3.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll() {

        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        // Verificar si el Id viene Null
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Category> consulta = categoryRepository.getCategory(category.getId());
            if (consulta.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }

    }

    public Category update(Category category) {

        if (category.getId() != null) {
            Optional<Category> consulta = categoryRepository.getCategory(category.getId());
            if (!consulta.isEmpty()) {
                if (category.getName() != null) {
                    consulta.get().setName(category.getName());
                }
                if (category.getDescription() != null)
                    consulta.get().setDescription(category.getDescription());
            }

            return categoryRepository.save(consulta.get());
        }

        return category;
    }

    public boolean deleteCategory(int id){
        Optional<Category> consulta = categoryRepository.getCategory(id);
        if (!consulta.isEmpty()) {
            categoryRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
}
