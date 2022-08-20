package br.com.infocomrobson.gerenciadorServicos.controller;

import br.com.infocomrobson.gerenciadorServicos.dto.ServicosForm;
import br.com.infocomrobson.gerenciadorServicos.model.Servicos;
import br.com.infocomrobson.gerenciadorServicos.service.impl.ServicosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {
    @Autowired
    private ServicosServiceImpl service;

    @GetMapping("/")
    public List<Servicos> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Servicos get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping("/create")
    public Servicos create(@RequestBody ServicosForm form){
        return service.create(form);
    }

    @PutMapping("/atualiza/{id}")
    public Servicos atualiza(@PathVariable Long id, @RequestBody ServicosForm form){
        return service.update(id, form);
    }

    @DeleteMapping("/deleta/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
