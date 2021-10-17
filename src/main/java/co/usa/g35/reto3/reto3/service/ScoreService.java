package co.usa.g35.reto3.reto3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g35.reto3.reto3.model.Score;
import co.usa.g35.reto3.reto3.repository.ScoreRepository;
@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public List<Score> getAll() {

        return scoreRepository.getAll();
    }

    public Optional<Score> getDepart(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        // Verificar si el Id viene Null
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {// Verifico si el Id existe e nl base de DAtos
            Optional<Score> consulta = scoreRepository.getScore(score.getIdScore());
            if (consulta.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }

    }
}
