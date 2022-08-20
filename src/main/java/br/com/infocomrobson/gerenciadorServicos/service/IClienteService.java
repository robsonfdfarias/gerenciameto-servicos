package br.com.infocomrobson.gerenciadorServicos.service;

import br.com.infocomrobson.gerenciadorServicos.dto.ClienteForm;
import br.com.infocomrobson.gerenciadorServicos.model.Cliente;
import br.com.infocomrobson.gerenciadorServicos.model.TipoServico;

import java.util.List;
import java.util.Optional;


public interface IClienteService {
    /*
    * @return Retorna todos os clientes
    */
    List<Cliente> getAll();
    /*
    * @return Retorna um aluno específico de acordo com o id passado
    */
    Cliente get(Long id);
    /*
    * Cria um novo cliente
    * @return Retorna o cliente criado
    */
    Cliente create(ClienteForm form);
    /*
    * deleta o cliente e os serviços feitos para ele
    */
    void delete(Long id);
    /*
    * Atualiza o cliente enviado
    * @return retorna o cliente atualizado
    */
    Cliente update(Long id, ClienteForm form);
    /*
    * @return Retorna todos os clientes com serviço igual ao serviço pesquisado
    */
    List<Cliente> findByServicosTipoServico(String servico);
}
