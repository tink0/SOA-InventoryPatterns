package sk.tuke.seregely.dipl.services.entities;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.CiselnikStavov;
import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Jazda;

@WebService()
public class CiselnikStavovService {

	final EntityDAO<CiselnikStavov> ciselnikDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.CiselnikStavov","id_stavu");

	@WebMethod()
	public CiselnikStavov retrieve(int id) {
		return ciselnikDAO.findById(id);
	}
	
	@WebMethod()
	public CiselnikStavov create(String nazovStavu, Jazda jazda) {
		CiselnikStavov novyStav = new CiselnikStavov();
		
		novyStav.setNazovStavu(nazovStavu);
		
		ciselnikDAO.persist(novyStav);
		
		return novyStav;
	}
	
	@WebMethod()
	public void delete(int id) {
		CiselnikStavov toDelete;
		toDelete = ciselnikDAO.findById(id);
		ciselnikDAO.delete(toDelete);
	}
	
	@WebMethod()
	public CiselnikStavov update(CiselnikStavov ciselnikStavov) {
		return ciselnikDAO.merge(ciselnikStavov);
	}
}