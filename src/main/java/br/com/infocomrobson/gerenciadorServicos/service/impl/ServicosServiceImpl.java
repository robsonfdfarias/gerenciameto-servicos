package br.com.infocomrobson.gerenciadorServicos.service.impl;

import br.com.infocomrobson.gerenciadorServicos.dto.ServicosForm;
import br.com.infocomrobson.gerenciadorServicos.model.Cliente;
import br.com.infocomrobson.gerenciadorServicos.model.Servicos;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;
import br.com.infocomrobson.gerenciadorServicos.repository.ClienteRepository;
import br.com.infocomrobson.gerenciadorServicos.repository.ServicosRepository;
import br.com.infocomrobson.gerenciadorServicos.repository.TipoServicoRepository;
import br.com.infocomrobson.gerenciadorServicos.service.IServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosServiceImpl implements IServicosService {
    @Autowired
    private ServicosRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @Override
    public List<Servicos> getAll() {
        return repository.findAll();
    }

    @Override
    public Servicos get(Long id) {
        Optional<Servicos> byId = repository.findById(id);
        Servicos servicos = byId.get();
        return servicos;
    }

    @Override
    public List<Servicos> findByTipoServicoNome(String tipoServico) {
        return repository.findByTipoServicoNome(tipoServico);
    }

    @Override
    public void delete(Long id) {
        Optional<Servicos> byId = repository.findById(id);
        Servicos servicos = byId.get();
        repository.delete(servicos);
    }

    @Override
    public Servicos update(Long id, ServicosForm form) {
        TipoServico tipoServico = tipoServicoRepository.getReferenceById(form.getTipoServico());
        Cliente cliente = clienteRepository.getReferenceById(form.getCliente());

        Optional<Servicos> byId = repository.findById(id);
        Servicos servicos = byId.get();
        if(form.getDescricaoServico() != null) servicos.setDescricaoServico(form.getDescricaoServico());
        if(form.getPreco() > 0.0) servicos.setPreco(form.getPreco());
        if(tipoServico != null) servicos.setTipoServico(tipoServico);
        if(form.getObservacao() != null) servicos.setObservacao(form.getObservacao());
        if(cliente != null) servicos.setCliente(cliente);
        servicos.setPago(form.isPago());
//        servicos.setDataInicio(form.getDataInicio());
        if(form.getDataFim() != null) servicos.setDataFim(form.getDataFim());

        return repository.save(servicos);
    }

    @Override
    public Servicos create(ServicosForm form) {
        TipoServico tipoServico = tipoServicoRepository.getReferenceById(form.getTipoServico());
        Cliente cliente = clienteRepository.getReferenceById(form.getCliente());
        Servicos servicos = new Servicos();
        servicos.setDescricaoServico(form.getDescricaoServico());
        servicos.setPreco(form.getPreco());
        servicos.setTipoServico(tipoServico);
        servicos.setObservacao(form.getObservacao());
        servicos.setCliente(cliente);
        servicos.setPago(form.isPago());
        servicos.setDataInicio(form.getDataInicio());
        servicos.setDataFim(form.getDataFim());

        return repository.save(servicos);
    }
}
