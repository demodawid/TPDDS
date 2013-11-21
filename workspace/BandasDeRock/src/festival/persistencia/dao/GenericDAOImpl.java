package festival.persistencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import festival.utils.HibernateUtil;

public abstract class GenericDAOImpl <T, ID extends Serializable> implements GenericDAO<T, ID> {
	protected Session getSession() {
        return HibernateUtil.getSession();
    }
 
    public ID save(T entity) {
        Session hibernateSession = this.getSession();        
        hibernateSession.beginTransaction();
        ID id = (ID) hibernateSession.save(entity);
        hibernateSession.getTransaction().commit();		 		
        return id;
    }
 
    public void merge(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.beginTransaction();
        hibernateSession.merge(entity);
        hibernateSession.getTransaction().commit();
    }
 
    public void delete(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.beginTransaction();
        hibernateSession.delete(entity);
        hibernateSession.getTransaction().commit();
    }
    
    public void update (T entity) {
    	Session hibernateSession = this.getSession();
    	hibernateSession.beginTransaction();
    	hibernateSession.update(entity);
    	hibernateSession.getTransaction().commit();
    }
    
 
    @SuppressWarnings("unchecked")
	public List findMany(final String queryString) {
        List T = null;
        Session session = this.getSession();
        session.beginTransaction();
        Query queryObject = session.createQuery(queryString);
        T = queryObject.list();
        session.getTransaction().commit();
        return T;
    }
    
    @SuppressWarnings("unchecked")
	public List findManyWithCriteria(Criteria criteria) {
        List T = null;         
        T = criteria.list();        
        return T;
    }
 
    public T findOne(Query query) {
        T t;
        t = (T) query.uniqueResult();
        return t;
    }
 
    public T findByID(Class clazz, Integer id) {
        Session hibernateSession = this.getSession();
        hibernateSession.beginTransaction();
        T t = null;
        t = (T) hibernateSession.get(clazz, id);
        hibernateSession.getTransaction().commit();
        return t;
    }
 
    public List findAll(Class clazz) {
        Session hibernateSession = this.getSession();
        hibernateSession.beginTransaction();
        List T = null;
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        T = query.list();
        hibernateSession.getTransaction().commit();	
        return T;
    }
    
}
