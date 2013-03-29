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
 * Home object for domain model class Suradnica.
 * @see sk.tuke.seregely.dipl.entity.model.Suradnica
 * @author Hibernate Tools
 */
public class SuradnicaHome {

	private static final Log log = LogFactory.getLog(SuradnicaHome.class);

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

	public void persist(Suradnica transientInstance) {
		log.debug("persisting Suradnica instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Suradnica instance) {
		log.debug("attaching dirty Suradnica instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Suradnica instance) {
		log.debug("attaching clean Suradnica instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Suradnica persistentInstance) {
		log.debug("deleting Suradnica instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Suradnica merge(Suradnica detachedInstance) {
		log.debug("merging Suradnica instance");
		try {
			Suradnica result = (Suradnica) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Suradnica findById(float id) {
		log.debug("getting Suradnica instance with id: " + id);
		try {
			Suradnica instance = (Suradnica) sessionFactory.getCurrentSession()
					.get("model.Suradnica", id);
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

	public List findByExample(Suradnica instance) {
		log.debug("finding Suradnica instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("model.Suradnica")
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
