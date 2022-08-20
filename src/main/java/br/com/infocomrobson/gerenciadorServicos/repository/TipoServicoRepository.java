package br.com.infocomrobson.gerenciadorServicos.repository;

import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
    public TipoServico findByNome(String nome);
}
