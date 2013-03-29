package sk.tuke.seregely.dipl.services.entities;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Pracovisko;
import sk.tuke.seregely.dipl.entity.model.Zakazka;

@WebService()
public class PracoviskoService {
	
final EntityDAO<Pracovisko> pracoviskoDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Pracovisko","id_pracoviska");
	
	@WebMethod()
	public Pracovisko retrieve(int id) {
		return pracoviskoDAO.findById(id);
	}
	
	@WebMethod()
	public Pracovisko create(String celeMeno) {
		Pracovisko novePracovisko = new Pracovisko();
		
		novePracovisko.setNazov(celeMeno);
	
		pracoviskoDAO.persist(novePracovisko);
		
		return novePracovisko;
	}
	
	@WebMethod()
	public void delete(int id) {
		Pracovisko toDelete;
		toDelete = pracoviskoDAO.findById(id);
		pracoviskoDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Pracovisko update(Pracovisko pracovisko) {
		return pracoviskoDAO.merge(pracovisko);
	}

}
