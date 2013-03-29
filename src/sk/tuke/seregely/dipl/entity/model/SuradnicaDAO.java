package sk.tuke.seregely.dipl.entity.model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class SuradnicaDAO extends EntityDAO<Suradnica> {

	public SuradnicaDAO(String name, String id) {
		super(name, id);
	}
	
	public List<Suradnica> findAllForRide(int idRide, Date from, Date to) {
		try {
			
			Query query = super.getSession().createQuery("from Suradnica where id_jazdy = ? and cas >= ? and cas < ?");
			query.setInteger(0, idRide);
			query.setDate(1, from);
			query.setDate(2, to);
			List<Suradnica> suradnice = query.list();
			return suradnice;
		} catch (HibernateException ex) {	
			
		} 
		return null;
	}

}
