package sk.tuke.seregely.dipl.services.entities;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Pracovisko;
import sk.tuke.seregely.dipl.entity.model.Veduci;
import sk.tuke.seregely.dipl.entity.model.Vodic;

@WebService()
public class VeduciService {
	
final EntityDAO<Veduci> veduciDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Veduci","id_veduceho");
	
	@WebMethod()
	public Veduci retrieve(int id) {
		return veduciDAO.findById(id);
	}
	
	@WebMethod()
	public Veduci create(String celeMeno, Pracovisko pracovisko, String email) {
		Veduci novyVeduci = new Veduci();
		
		novyVeduci.setCeleMeno(celeMeno);
		novyVeduci.setPracovisko(pracovisko);
		novyVeduci.setEmail(email);
	
		veduciDAO.persist(novyVeduci);
		
		return novyVeduci;
	}
	
	@WebMethod()
	public void delete(int id) {
		Veduci toDelete;
		toDelete = veduciDAO.findById(id);
		veduciDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Veduci update(Veduci jazda) {
		return veduciDAO.merge(jazda);
	}

}
