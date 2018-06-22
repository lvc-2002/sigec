package br.com.sigec.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sigec.model.Cliente;

public class JPAClienteDAO implements GenericClienteDAO {
	
	private EntityManager em;
	
	public JPAClienteDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salva(Cliente c) {
		em.persist(c);
	}

	@Override
	public void atualiza(Cliente c) {
		em.merge(c);
	}

	@Override
	public void exclui(Cliente c) {
		em.remove(c);
	}

	@Override
	public Cliente pesquisa(long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> pesquisa(String nome) {
		TypedQuery<Cliente> tq = em.createQuery("select c from Cliente c where upper(c.nome) like upper(:n)",
				Cliente.class);
		tq.setParameter("n", "%"+nome+"%");
		return tq.getResultList();
	}

	@Override
	public List<Cliente> lista() {
		return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

}
