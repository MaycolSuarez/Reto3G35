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

    public Score update(Score score) {

        if (score.getIdScore() != null) {
            Optional<Score> consulta = scoreRepository.getScore(score.getIdScore());
            if (!consulta.isEmpty()) {
                if (score.getCalificacion() != null) {
                    consulta.get().setCalificacion(score.getCalificacion());
                }
                if (score.getMensaje() != null) {
                    consulta.get().setMensaje(score.getMensaje());
                }

            }

            return scoreRepository.save(consulta.get());
        }

        return score;
    }

    public boolean deleteScore(int id){
        Optional<Score> consulta = scoreRepository.getScore(id);
        if (!consulta.isEmpty()) {
            scoreRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
}
