package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import entity.Agenda;

public class AgendaDao {

	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;
	
	public void create(Agenda a) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(a);
		transaction.commit();
		session.close();
	}
	
	public void update(Agenda a) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(a);
		transaction.commit();
		session.close();
	}
	
	public void delete(Agenda a) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(a);
		transaction.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agenda> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Agenda.class);
		List<Agenda> lista = criteria.list();
		session.close();
		return lista;
	}
	
	public Agenda findByCode(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Agenda a = (Agenda) session.get(Agenda.class, cod);
		session.close();
		return a;
	}
}
