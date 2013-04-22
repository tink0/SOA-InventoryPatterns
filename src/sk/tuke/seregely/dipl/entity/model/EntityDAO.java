package sk.tuke.seregely.dipl.entity.model;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.HibernateUtil;

public class EntityDAO<T> {

	private static final Log log = LogFactory.getLog(EntityDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();
	
	private String className;
	
	private String idName;
	
	public EntityDAO(String name, String id) {
		sessionFactory.openSession();
		className = name;
		idName = id;
	}
	
	

	protected SessionFactory getSessionFactory() {

			return HibernateUtil.getSessionFactory();
			
	}
	
	public void persist(T transientInstance) {
		Transaction tx = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.persist(transientInstance);
			tx.commit();
		} catch (HibernateException e) {
			log.error("persist failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
	}


	public void delete(T persistentInstance) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(persistentInstance);
			log.debug("delete successful");
			tx.commit();
		} catch (HibernateException e) {
			log.error("delete failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
	}

	public T merge(T detachedInstance) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();		
			session.merge(detachedInstance);
			log.debug("merge successful");
			tx.commit();
			return detachedInstance;
		} catch (HibernateException e) {
			log.error("merge failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
	}

	public T findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Query query = session.createQuery("from "+className+" where "+idName+" = ?");
			query.setInteger(0, id);
			T instance =(T) query.uniqueResult();
			
			if (instance == null) {
				log.debug("get successful, no instance found");
			}
			
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
		
			throw re;
		}
	}

	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from "+className);
			List<T> jazdy = query.list();
			return jazdy;
		} catch (HibernateException ex) {	
			log.debug("findAll Error:" +ex);
		} 
		return null;
	}

	
	public String getClassName() {
		return className;
	}
	
	public String getIdName() {
		return idName;
	}
	
	
}
