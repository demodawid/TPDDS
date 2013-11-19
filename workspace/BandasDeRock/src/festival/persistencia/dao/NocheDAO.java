package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import festival.negocio.model.Noche;

public interface NocheDAO extends GenericDAO<Noche, Serializable> {
	public Noche getEntityById(Serializable id);
	public List getList();
	public List search(Map<String, Object> parameterMap);
	public void update(Noche entity);
	public void deleteById(Serializable id);
	public Integer save(Noche entity);
}
