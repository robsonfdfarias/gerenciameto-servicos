package br.com.infocomrobson.gerenciadorServicos.controller;

import br.com.infocomrobson.gerenciadorServicos.dto.ClienteForm;
import br.com.infocomrobson.gerenciadorServicos.model.Cliente;
import br.com.infocomrobson.gerenciadorServicos.model.Servicos;
import br.com.infocomrobson.gerenciadorServicos.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl service;

    @GetMapping("/")
    public List<Cliente> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping("/create")
    public Cliente create(@RequestBody ClienteForm form){
        return service.create(form);
    }

    @PutMapping("/atualiza/{id}")
    public Cliente atualiza(@PathVariable Long id, @RequestBody ClienteForm form){
        return service.update(id, form);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/list/{id}")
    public List<Servicos> lista(@PathVariable Long id){
        return service.get(id).getServicos();
    }
}
