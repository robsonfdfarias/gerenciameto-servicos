package br.com.infocomrobson.gerenciadorServicos.service.impl;

import br.com.infocomrobson.gerenciadorServicos.dto.ClienteForm;
import br.com.infocomrobson.gerenciadorServicos.model.Cliente;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;
import br.com.infocomrobson.gerenciadorServicos.repository.ClienteRepository;
import br.com.infocomrobson.gerenciadorServicos.repository.TipoServicoRepository;
import br.com.infocomrobson.gerenciadorServicos.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente get(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        Cliente cliente1 = new Cliente();
        cliente1.setId(cliente.get().getId());
        cliente1.setNome(cliente.get().getNome());
        cliente1.setCidade(cliente.get().getCidade());
        cliente1.setObservacao(cliente.get().getObservacao());
        cliente1.getServicos().addAll(cliente.get().getServicos());
        cliente1.setTelefone(cliente.get().getTelefone());
        return cliente1;
    }

    @Override
    public Cliente create(ClienteForm form) {
        Cliente cliente = new Cliente();
        cliente.setNome(form.getNome());
        cliente.setCidade(form.getCidade());
        cliente.setObservacao(form.getObservacao());
        cliente.setTelefone(form.getTelefone());
        return repository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        Cliente cliente1 = cliente.get();
        cliente1.setNome(cliente.get().getNome());
        cliente1.setCidade(cliente.get().getCidade());
        cliente1.setObservacao(cliente.get().getObservacao());
        cliente1.getServicos().addAll(cliente.get().getServicos());
        cliente1.setTelefone(cliente.get().getTelefone());
        repository.delete(cliente1);
    }

    @Override
    public Cliente update(Long id, ClienteForm form) {
        Optional<Cliente> cliente = repository.findById(id);
        Cliente cliente1 = cliente.get();
        if(form.getNome() != null) cliente1.setNome(form.getNome());
        if(form.getCidade() != null) cliente1.setCidade(form.getCidade());
        if(form.getObservacao() != null) cliente1.setObservacao(form.getObservacao());
        if(form.getTelefone() != null) cliente1.setTelefone(form.getTelefone());
        return repository.save(cliente1);
    }

    @Override
    public List<Cliente> findByServicosTipoServico(String servico) {
        TipoServico tipoServico = tipoServicoRepository.findByNome(servico);
        return repository.findByServicosTipoServico(tipoServico);
    }
}
