package br.com.infocomrobson.gerenciadorServicos.repository;

import br.com.infocomrobson.gerenciadorServicos.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {
    List<Servicos> findByTipoServicoNome(String tipoServico);
}
