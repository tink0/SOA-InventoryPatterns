package sk.tuke.seregely.dipl.entity.model;

// Generated Mar 18, 2013 10:50:04 AM by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Vozidlo.
 * @see sk.tuke.seregely.dipl.entity.model.Vozidlo
 * @author Hibernate Tools
 */
public class VozidloHome {

	private static final Log log = LogFactory.getLog(VozidloHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("sessFact");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vozidlo transientInstance) {
		log.debug("persisting Vozidlo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vozidlo instance) {
		log.debug("attaching dirty Vozidlo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vozidlo instance) {
		log.debug("attaching clean Vozidlo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vozidlo persistentInstance) {
		log.debug("deleting Vozidlo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vozidlo merge(Vozidlo detachedInstance) {
		log.debug("merging Vozidlo instance");
		try {
			Vozidlo result = (Vozidlo) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vozidlo findById(int id) {
		log.debug("getting Vozidlo instance with id: " + id);
		try {
			Vozidlo instance = (Vozidlo) sessionFactory.getCurrentSession()
					.get("model.Vozidlo", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vozidlo instance) {
		log.debug("finding Vozidlo instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("model.Vozidlo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
