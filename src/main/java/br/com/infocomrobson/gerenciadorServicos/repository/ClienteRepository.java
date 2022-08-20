package br.com.infocomrobson.gerenciadorServicos.repository;

import br.com.infocomrobson.gerenciadorServicos.model.Cliente;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByServicosTipoServico(TipoServico servico);
}
