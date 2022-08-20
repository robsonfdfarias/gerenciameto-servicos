package br.com.infocomrobson.gerenciadorServicos.controller;

import br.com.infocomrobson.gerenciadorServicos.dto.TipoServicoForm;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;
import br.com.infocomrobson.gerenciadorServicos.service.impl.TipoServicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoServico")
public class TipoServicoController {
    @Autowired
    private TipoServicoServiceImpl service;

    @GetMapping("/")
    public List<TipoServico> getAll(){
        return service.getAll();
    }

    @PostMapping(value = "/create")
    public TipoServico create(@RequestBody TipoServicoForm form){
        return service.create(form);
    }

    @GetMapping("/{id}")
    public TipoServico getById(@PathVariable Long id){
        return service.get(id);
    }

    @PutMapping("/atualiza/{id}")
    public TipoServico update(@PathVariable Long id, @RequestBody TipoServicoForm form){
        return service.update(id, form);
    }
}
