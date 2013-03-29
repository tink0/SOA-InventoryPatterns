package sk.tuke.seregely.dipl.services.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Jazda;
import sk.tuke.seregely.dipl.entity.model.Pracovisko;
import sk.tuke.seregely.dipl.entity.model.Vodic;

@WebService()
public class VodicService {

	final EntityDAO<Vodic> vodicDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Vodic","cislo_vodica");
	
	@WebMethod()
	public Vodic retrieve(int id) {
		return vodicDAO.findById(id);
	}
	
	@WebMethod()
	public Vodic create(String celeMeno, Pracovisko pracovisko, String email) {
		Vodic novyVodic = new Vodic();
		
		novyVodic.setCeleMeno(celeMeno);
		novyVodic.setPracovisko(pracovisko);
		novyVodic.setEmail(email);
	
		vodicDAO.persist(novyVodic);
		
		return novyVodic;
	}
	
	@WebMethod()
	public void delete(int id) {
		Vodic toDelete;
		toDelete = vodicDAO.findById(id);
		vodicDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Vodic update(Vodic jazda) {
		return vodicDAO.merge(jazda);
	}

}
