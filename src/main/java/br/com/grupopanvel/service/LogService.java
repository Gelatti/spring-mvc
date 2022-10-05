package br.com.grupopanvel.service;

import br.com.grupopanvel.entity.LogEntity;
import br.com.grupopanvel.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogService {

    LogRepository repository;

    public void upsert(LogEntity entity) {
        repository.save(entity);
    }

    public List<LogEntity> findAll() {
        return repository.findAll();
    }

    public List<LogEntity> findAll(Sort sort) {
        return repository.findAll(sort);
    }
}
