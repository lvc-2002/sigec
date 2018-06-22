package br.com.sigec.dao;

import java.util.List;

import br.com.sigec.model.Cliente;

public interface GenericClienteDAO {
	
	public void salva(Cliente c);
	
	public void atualiza(Cliente c);
	
	public void exclui(Cliente c);
	
	public Cliente pesquisa(long id);
	
	public List<Cliente> pesquisa(String nome);
	
	public List<Cliente> lista();

}
