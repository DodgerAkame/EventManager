package simon.remy.ensisa.controller;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {

		return hemf.getSessionFactory();
	}

	private Session getCurrentSession() {
		return sessionfactory.openSession();
	}

	private void setCurrentSession(SessionFactory sessionFactory) {
		this.sessionfactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addEvent(Event e) {
		getCurrentSession().save(e);
	}

	@Override
	@Transactional
	public void updateEvent(Event e) {
		Event eventToUpdate = getEvent(e.getId());
		eventToUpdate.setDescription(e.getDescription());
		eventToUpdate.setHours(e.getHours());
		eventToUpdate.setLieu(e.getLieu());
		eventToUpdate.setTitle(e.getTitle());
		eventToUpdate.setType(e.getType());
		eventToUpdate.setDate(e.getDate());
		eventToUpdate.setFavorite(e.isFavorite());

		Session session;
		session = getCurrentSession();
		try {
			org.hibernate.Transaction tx = session.beginTransaction();
			session.update(eventToUpdate);
			tx.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional
	public Event getEvent(int id) {
		Event event = (Event) getCurrentSession().get(Event.class, id);

		return event;
	}

	@Override
	@Transactional
	public void deleteEvent(int id) {
//		Event event = (Event) getCurrentSession().get(Event.class, id);
//		if (event != null)
//			getCurrentSession().delete(event);

		Session session = getCurrentSession();
		try {
			Event event = (Event) session.get(Event.class, id);
			org.hibernate.Transaction tx = session.beginTransaction();
			session.delete(event);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
	}

	@Override
	@Transactional
	public List<Event> getEvents() {
		return getCurrentSession().createQuery("from events").list();
	}

}
