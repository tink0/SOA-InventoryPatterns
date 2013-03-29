package sk.tuke.seregely.dipl.services.entities;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sk.tuke.seregely.dipl.entity.model.EntityDAO;
import sk.tuke.seregely.dipl.entity.model.Vodic;
import sk.tuke.seregely.dipl.entity.model.Vozidlo;
import sk.tuke.seregely.dipl.entity.model.VozidloVodic;

@WebService()
public class VozidloVodicService {

final EntityDAO<VozidloVodic> vozidloVodicDAO = new EntityDAO("sk.tuke.seregely.dipl.entity.model.VozidloVodic","id");
	
	@WebMethod()
	public VozidloVodic retrieve(int id) {
		return vozidloVodicDAO.findById(id);
	}
	
	@WebMethod()
	public VozidloVodic create(Vodic vodic, Vozidlo vozidlo, String kod) {
		VozidloVodic noveVozidloVodic = new VozidloVodic();
		
		noveVozidloVodic.setVodic(vodic);
		noveVozidloVodic.setVozidlo(vozidlo);
	
		vozidloVodicDAO.persist(noveVozidloVodic);
		
		return noveVozidloVodic;
	}
	
	@WebMethod()
	public void delete(int id) {
		VozidloVodic toDelete;
		toDelete = vozidloVodicDAO.findById(id);
		vozidloVodicDAO.delete(toDelete);
	}
	
	@WebMethod()
	public VozidloVodic update(VozidloVodic zakazka) {
		return vozidloVodicDAO.merge(zakazka);
	}

}
