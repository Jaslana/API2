package com.Api2.API2.Controller;

import com.Api2.API2.Model.ContaModel;
import com.Api2.API2.Repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
@RequestMapping
public class saqueController {

    @Autowired
    private ContaRepository repository;

    @PostMapping(path = "/{cpf}")
    public String alterarQtdSaquesBanco(@PathVariable(value = "nconta") String nconta) {
        Optional<ContaModel> busca = repository.findBynconta(nconta);
        if (busca.isPresent()) {
            busca.map(map -> {
                map.setQtdSaques(map.getQtdSaques() != null ? map.getQtdSaques() + 1 : 1);
                ContaModel updated = repository.save(map);
                return ResponseEntity.ok().body(updated);
            });
            return "Salvo" + ResponseEntity.ok().build();
        }
        return "Não foi Salvo" + ResponseEntity.badRequest().build();
    }
}
