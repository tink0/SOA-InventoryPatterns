package sk.tuke.seregely.dipl.services.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Tankovanie;
import sk.tuke.seregely.dipl.entity.model.Zakazka;

@WebService()
public class TankovanieService {
	
final EntityDAO<Tankovanie> tankovanieDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Tankovanie","id_tankovania");
	
	@WebMethod()
	public Tankovanie retrieve(int id) {
		return tankovanieDAO.findById(id);
	}
	
	@WebMethod()
	public Tankovanie create(Date casTankovania, int idVozidla, int typPaliva) {
		Tankovanie noveTankovanie = new Tankovanie();
		
		noveTankovanie.setCasTankovania(casTankovania);
		noveTankovanie.setIdVozidla(idVozidla);
		noveTankovanie.setTypPaliva(typPaliva);
	
		tankovanieDAO.persist(noveTankovanie);
		
		return noveTankovanie;
	}
	
	@WebMethod()
	public void delete(int id) {
		Tankovanie toDelete;
		toDelete = tankovanieDAO.findById(id);
		tankovanieDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Tankovanie update(Tankovanie tankovanie) {
		return tankovanieDAO.merge(tankovanie);
	}

}
