package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDAO<Entity, ID extends Serializable> {
	
	Entity getEntityById(ID id);
	
    List getList();
    
    List search(Map<String, Object> parameterMap);
 
    ID save(Entity entity);
 
    void update(Entity entity);
 
    void delete(Entity entity);
 
    void deleteById(ID id);
}
