package br.com.grupopanvel.api;

import br.com.grupopanvel.entity.PessoaEntity;
import br.com.grupopanvel.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API REST de Pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    PessoaService service;

    @PostMapping("/pessoa")
    @ApiOperation(value = "Insere uma nova Pessoa")
    public Long create(@RequestBody PessoaEntity entity) {
        service.upsert(entity);
        return entity.getId();
    }

    @PutMapping("/pessoa/update")
    @ApiOperation(value = "Atualiza os dados de Pessoa")
    public boolean update(@RequestBody PessoaEntity entity) {
        service.upsert(entity);
        return true;
    }

    @DeleteMapping("/pessoa/delete")
    @ApiOperation(value = "Remove Pessoa")
    public void delete(@RequestBody PessoaEntity entity) {
        service.delete(entity);
    }

    @GetMapping("/pessoa/{id}")
    @ApiOperation(value = "Retorna uma única Pessoa")
    public PessoaEntity findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @Cacheable("pessoas")
    @GetMapping("/pessoas")
    @ApiOperation(value = "Retorna uma lista de todas Pessoas")
    public List<PessoaEntity> findAll() {
        Sort sort = Sort.by("id").descending();
        return service.findAll(sort);
    }
}
