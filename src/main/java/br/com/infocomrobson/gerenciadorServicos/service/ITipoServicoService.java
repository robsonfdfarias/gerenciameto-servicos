package br.com.infocomrobson.gerenciadorServicos.service;


import br.com.infocomrobson.gerenciadorServicos.dto.TipoServicoForm;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;

import java.util.List;

public interface ITipoServicoService {
    /*
    * @return todos os serviços
    */
    List<TipoServico> getAll();

    /*
    * @return o tipo de serviço solicitado pelo id
    */
    TipoServico get(Long id);

    /*
    * cria um tipo de serviço
    * @return o tipo de serviço criado
    */
    TipoServico create(TipoServicoForm form);

    /*
    * @return o tipo de servico solicitado pelo nome
    */
    TipoServico findByNome(String nome);

    /*
    * Atualiza o tipo de serviço
    * @return o servico atualizado
    */
    TipoServico update(Long id, TipoServicoForm form);

}
