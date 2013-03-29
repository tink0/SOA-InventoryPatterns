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
 * Home object for domain model class Vodic.
 * @see sk.tuke.seregely.dipl.entity.model.Vodic
 * @author Hibernate Tools
 */
public class VodicHome {

	private static final Log log = LogFactory.getLog(VodicHome.class);

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

	public void persist(Vodic transientInstance) {
		log.debug("persisting Vodic instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vodic instance) {
		log.debug("attaching dirty Vodic instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vodic instance) {
		log.debug("attaching clean Vodic instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vodic persistentInstance) {
		log.debug("deleting Vodic instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vodic merge(Vodic detachedInstance) {
		log.debug("merging Vodic instance");
		try {
			Vodic result = (Vodic) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vodic findById(int id) {
		log.debug("getting Vodic instance with id: " + id);
		try {
			Vodic instance = (Vodic) sessionFactory.getCurrentSession().get(
					"model.Vodic", id);
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

	public List findByExample(Vodic instance) {
		log.debug("finding Vodic instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("model.Vodic")
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
