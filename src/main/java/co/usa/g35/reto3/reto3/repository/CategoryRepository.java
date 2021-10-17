package co.usa.g35.reto3.reto3.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g35.reto3.reto3.model.Category;
import co.usa.g35.reto3.reto3.repository.crud.CategoryCrudRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class CategoryRepository {
    @Autowired
    CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryCrudRepository.save(category);
    }
}
