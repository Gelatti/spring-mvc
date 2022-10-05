package br.com.grupopanvel.api;

import br.com.grupopanvel.entity.LogEntity;
import br.com.grupopanvel.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API REST de Pessoas")
@CrossOrigin(origins = "*")
public class LogController {

    @Autowired
    LogService service;

    @GetMapping("/logs")
    @ApiOperation(value = "Retorna uma lista de todos os Logs de Pessoa")
    public List<LogEntity> findAll() {
        return service.findAll();
    }

}
