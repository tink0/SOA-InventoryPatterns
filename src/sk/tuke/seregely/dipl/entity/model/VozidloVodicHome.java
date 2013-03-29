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
 * Home object for domain model class VozidloVodic.
 * @see sk.tuke.seregely.dipl.entity.model.VozidloVodic
 * @author Hibernate Tools
 */
public class VozidloVodicHome {

	private static final Log log = LogFactory.getLog(VozidloVodicHome.class);

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

	public void persist(VozidloVodic transientInstance) {
		log.debug("persisting VozidloVodic instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VozidloVodic instance) {
		log.debug("attaching dirty VozidloVodic instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VozidloVodic instance) {
		log.debug("attaching clean VozidloVodic instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VozidloVodic persistentInstance) {
		log.debug("deleting VozidloVodic instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VozidloVodic merge(VozidloVodic detachedInstance) {
		log.debug("merging VozidloVodic instance");
		try {
			VozidloVodic result = (VozidloVodic) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VozidloVodic findById(sk.tuke.seregely.dipl.entity.model.VozidloVodicId id) {
		log.debug("getting VozidloVodic instance with id: " + id);
		try {
			VozidloVodic instance = (VozidloVodic) sessionFactory
					.getCurrentSession().get("model.VozidloVodic", id);
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

	public List findByExample(VozidloVodic instance) {
		log.debug("finding VozidloVodic instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("model.VozidloVodic")
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
