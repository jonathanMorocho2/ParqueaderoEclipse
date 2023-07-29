package ec.edu.ups.parqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Ticket;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class TicketDao implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Ticket ticket) {
		em.persist(ticket);
	}
	
	public void update(Ticket ticket) {
		em.merge(ticket);
	}
	
	public Ticket read(int codigoTic) {
		Ticket p = em.find(Ticket.class, codigoTic);
		return p;
	}
	
	public void delete(int codigoTic) {
		Ticket p = em.find(Ticket.class, codigoTic);
		em.remove(p);
	}
	
	public List<Ticket> getAll(){
		String jpql = "SELECT p FROM Ticket p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
