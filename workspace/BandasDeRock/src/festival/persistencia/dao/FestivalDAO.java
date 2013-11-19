package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import festival.negocio.model.Festival;

public interface FestivalDAO extends GenericDAO<Festival, Serializable>{
	public Festival getEntityById(Serializable id);
	public List getList();
	public List search(Map<String, Object> parameterMap);
	public void update(Festival entity);
	public void deleteById(Serializable id);
	public Integer save(Festival entity);
}
