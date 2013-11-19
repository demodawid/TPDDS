package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import festival.negocio.model.Butaca;

public interface ButacaDAO extends GenericDAO<Butaca, Serializable>{
	public Butaca getEntityById(Serializable id);
	public List getList();
	public List search(Map<String, Object> parameterMap);
	public void update(Butaca entity);
	public void deleteById(Serializable id);
	public Integer save(Butaca entity);
}
