package br.com.infocomrobson.gerenciadorServicos.service.impl;

import br.com.infocomrobson.gerenciadorServicos.dto.TipoServicoForm;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;
import br.com.infocomrobson.gerenciadorServicos.repository.TipoServicoRepository;
import br.com.infocomrobson.gerenciadorServicos.service.ITipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoServicoServiceImpl implements ITipoServicoService {
    @Autowired
    private TipoServicoRepository repository;

    @Override
    public List<TipoServico> getAll() {
        return repository.findAll();
    }

    @Override
    public TipoServico get(Long id) {
        Optional<TipoServico> byId = repository.findById(id);
        TipoServico servico = new TipoServico();
        servico.setNome(byId.get().getNome());
        servico.setId(byId.get().getId());
        return servico;
    }

    @Override
    public TipoServico create(TipoServicoForm form) {
        TipoServico servico = new TipoServico();
        servico.setNome(form.getNome());
        return repository.save(servico);
    }

    @Override
    public TipoServico findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public TipoServico update(Long id, TipoServicoForm form) {
        Optional<TipoServico> byId = repository.findById(id);
        TipoServico servico = new TipoServico();
        servico.setNome(form.getNome());
        servico.setId(byId.get().getId());
        return repository.save(servico);
    }
}
