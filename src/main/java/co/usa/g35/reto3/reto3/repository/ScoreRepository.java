package co.usa.g35.reto3.reto3.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g35.reto3.reto3.model.Score;
import co.usa.g35.reto3.reto3.repository.crud.ScoreCrudRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class ScoreRepository {
    @Autowired
   ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score) {
        return scoreCrudRepository.save(score);
    }
}
