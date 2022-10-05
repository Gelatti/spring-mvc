package br.com.grupopanvel.service;

import br.com.grupopanvel.entity.PessoaEntity;
import br.com.grupopanvel.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    PessoaRepository repository;

    public void upsert(PessoaEntity entity) {
        entity.setDataModificacao(LocalDateTime.now());
        repository.save(entity);
    }

    public void delete(PessoaEntity entity) {
        repository.delete(entity);
    }

    public PessoaEntity findById(Long id) {
        return repository.findById(id).get();
    }

    public List<PessoaEntity> findAll(Sort sort) {
        return repository.findAll(sort);
    }
}
