package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:04 AM by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import db.HibernateUtil;

/**
 * Home object for domain model class Jazda.
 * @see sk.tuke.seregely.dipl.entity.model.Jazda
 * @author Hibernate Tools
 */
public class JazdaHome {

	private static final Log log = LogFactory.getLog(JazdaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		HibernateUtil.getSessionFactory();
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Jazda transientInstance) {
		log.debug("persisting Jazda instance");
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			sess.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (HibernateException e) {
			log.error("persist failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
		finally {
			sess.close();
		}
	}

	public void attachDirty(Jazda instance) {
		log.debug("attaching dirty Jazda instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	public void delete(Jazda persistentInstance) {
		log.debug("deleting Jazda instance");
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			sess.delete(persistentInstance);
			log.debug("delete successful");
			tx.commit();
		} catch (HibernateException e) {
			log.error("delete failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
		finally {
			sess.close();
		}
	}

	public Jazda merge(Jazda detachedInstance) {
		log.debug("merging Jazda instance");
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			Jazda result = (Jazda) sess.merge(detachedInstance);
			log.debug("merge successful");
			tx.commit();
			return result;
		} catch (HibernateException e) {
			log.error("merge failed", e);
			if(tx != null) tx.rollback();
			throw e;
		}
		finally {
			sess.close();
		}
	}

	public Jazda findById(int id) {
		log.debug("getting Jazda instance with id: " + id);
		Session sess = null;
		try {
			sess = sessionFactory.openSession();
			Query query = sess.createQuery("from sk.tuke.seregely.dipl.entity.model.Jazda where id_jazdy = ?");
			query.setInteger(0, id);
			Jazda instance =(Jazda) query.uniqueResult();
			
			if (instance == null) {
				log.debug("get successful, no instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jazda> findAll() {
		Session sess = null;
		try {
			sess = sessionFactory.openSession();
			Query query = sess.createQuery("from sk.tuke.seregely.dipl.entity.model.Jazda");
			List<Jazda> jazdy = query.list();
			return jazdy;
		} catch (HibernateException ex) {	
			log.debug("findAll Error:" +ex);
		} finally {
			sess.close();
		}
		return null;
	}
}
