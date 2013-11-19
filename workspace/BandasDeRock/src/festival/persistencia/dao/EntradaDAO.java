package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import festival.negocio.model.Entrada;

public interface EntradaDAO extends GenericDAO<Entrada, Serializable>{
	public Entrada getEntityById(Serializable id);
	public List getList();
	public List search(Map<String, Object> parameterMap);
	public void update(Entrada entity);
	public void deleteById(Serializable id);
	public Integer save(Entrada entity);
}
