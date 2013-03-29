package sk.tuke.seregely.dipl.services.entities;

import javax.jws.WebMethod;
import javax.jws.WebService;
import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Vozidlo;

@WebService()
public class VozidloService {

	final EntityDAO<Vozidlo> vozidloDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.Vozidlo","id_vozidla");
	
	@WebMethod()
	public Vozidlo retrieve(int id) {
		return vozidloDAO.findById(id);
	}
	
	@WebMethod()
	public Vozidlo create(Float skutocnyStavPaliva, String spz, String typVozidla, Float tachometer) {
		Vozidlo noveVozidlo = new Vozidlo();
		noveVozidlo.setSkutocnyStavPaliva(skutocnyStavPaliva);
		noveVozidlo.setSpz(spz);  
		noveVozidlo.setTypVozidla(typVozidla);
		noveVozidlo.setTachometer(tachometer);
		
		vozidloDAO.persist(noveVozidlo);
		
		return noveVozidlo;
	}
	
	@WebMethod()
	public void delete(int id) {
		Vozidlo toDelete;
		toDelete = vozidloDAO.findById(id);
		vozidloDAO.delete(toDelete);
	}
	
	@WebMethod()
	public Vozidlo update(Vozidlo vozidlo) {
		return vozidloDAO.merge(vozidlo);
	}

}
