package sk.tuke.seregely.dipl.entity.model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class JazdaDAO extends EntityDAO<Jazda>{

	public JazdaDAO(String name, String id) {
		super(name, id);
	}
	
	public List<Jazda> findAllForVehicle(int idVehicle, Date from, Date to) {
		try {
			
			Query query = super.getSessionFactory().getCurrentSession().createQuery("from Jazda where id_vozidla = ? and start >= ? and koniec < ?");
			query.setInteger(0, idVehicle);
			query.setDate(1, from);
			query.setDate(2, to);
			List<Jazda> jazdy = query.list();
			return jazdy;
		} catch (HibernateException ex) {	
					} 
		return null;
	}
	
	public List<Jazda> findAllForZakazka(int idZakazky) {
		try {
			
			Query query = super.getSessionFactory().getCurrentSession().createQuery("from Jazda where id_zakazky = ?");
			query.setInteger(0, idZakazky);
			List<Jazda> jazdy = query.list();
			return jazdy;
		} catch (HibernateException ex) {	
					} 
		return null;
	}
	
	public List<Jazda> findAllForVodic(int idVodica) {
		try {
			
			Query query = super.getSessionFactory().getCurrentSession().createQuery("from Jazda where cislo_vodica = ?");
			query.setInteger(0, idVodica);
			
			List<Jazda> jazdy = query.list();
			return jazdy;
		} catch (HibernateException ex) {	
					
		} 
		return null;
	}
	
	public List<Jazda> findAllForVodicAndVozidlo(int idVodica, int idVozidla) {
		try {
			
			Query query = super.getSessionFactory().getCurrentSession().createQuery("from Jazda where cislo_vodica = ? and id_vozidla = ?");
			query.setInteger(0, idVodica);
			query.setInteger(1, idVozidla);
			
			List<Jazda> jazdy = query.list();
			return jazdy;
		} catch (HibernateException ex) {	
					
		} 
		return null;
	}
	public List<Jazda> findInState(int idVozidla, int idState, Date from, Date to, int stav) {
		try {
			Query query = super.getSessionFactory().getCurrentSession().createQuery("from Jazda j inner join stav_jazdy s where j.id_vozidla = ? and j.start >= ? and j.koniec < ? and s.id_stavu = ?");
			query.setInteger(0, idVozidla);
			query.setDate(1, from);
			query.setDate(2, to);
			query.setInteger(3, stav);
			List<Jazda> jazdy = query.list();
			return jazdy;
		} catch (HibernateException hE) {
		//	hE.fuckYourself();
		}
		return null;
	}
	
}
