package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import festival.negocio.model.Banda;

public interface BandaDao extends GenericDAO<Banda, Serializable>{
	public Banda getEntityById(Serializable id);
	public List getList();
	public List search(Map<String, Object> parameterMap);
	public void update(Banda entity);
	public void deleteById(Serializable id);
}
