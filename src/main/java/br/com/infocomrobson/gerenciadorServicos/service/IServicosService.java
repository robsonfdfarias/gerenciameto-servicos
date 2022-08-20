package br.com.infocomrobson.gerenciadorServicos.service;

import br.com.infocomrobson.gerenciadorServicos.dto.ServicosForm;
import br.com.infocomrobson.gerenciadorServicos.model.Servicos;

import java.util.List;

public interface IServicosService {
    /*
    * @return todos os serviços
    */
    List<Servicos> getAll();

    /*
    * @return O serviço espicificado pelo id
    */
    Servicos get(Long id);

    /*
    * @return todos os serviços com o tipo determinado pelo tipoServico
    */
    List<Servicos> findByTipoServicoNome(String tipoServico);

    /*
    * Deleta o serviço especificado pelo id
    */
    void delete(Long id);

    /*
    * Atualiza o serviço indicado pelo id
    * @return o serviço atualizado
    */
    Servicos update(Long id, ServicosForm form);

    /*
    * Cria um serviço
    * @return o serviço criado
    */
    Servicos create(ServicosForm form);
}
