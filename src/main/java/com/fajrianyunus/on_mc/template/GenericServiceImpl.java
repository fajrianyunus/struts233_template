package com.fajrianyunus.on_mc.template;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.ejb.HibernateEntityManager;

public class GenericServiceImpl<initiatingClassName, idType> implements GenericService<initiatingClassName, idType> {
	private EntityManagerFactory emf;
    private EntityManager em;
    private HibernateEntityManager hem;
    
    private Class initiatingClass;
    
    protected GenericServiceImpl(Class initiatingClass) {
    	this.initiatingClass = initiatingClass;
    }
    
    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
        hem = (HibernateEntityManager) em;
    }

	@Override
	public List getAll() {
		Session session = hem.getSession();
        Criteria crit = session.createCriteria(initiatingClass);
        session.getTransaction().begin();
        List<initiatingClassName> result = crit.list();
        session.getTransaction().commit();		
        return result;
	}

	@Override
	public void saveOrUpdate(initiatingClassName entity) {
		Session session = hem.getSession();
        session.getTransaction().begin();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
	}

	@Override
	public Serializable save(initiatingClassName entity) {
		Session session = hem.getSession();
        session.getTransaction().begin();
        Serializable output = session.save(entity);
        session.getTransaction().commit();
        return output;
	}

	@Override
	public void update(initiatingClassName entity) {
		Session session = hem.getSession();
        session.getTransaction().begin();
        session.update(entity);
        session.getTransaction().commit();
	}

	@Override
	public void deleteById(idType id) {
		em.getTransaction().begin();
		initiatingClassName empl = (initiatingClassName) em.find(initiatingClass, id);
        if (empl != null) {
            em.remove(empl);
        }
        em.getTransaction().commit();
	}

	@Override
	public initiatingClassName getById(idType id) {
		em.getTransaction().begin();
		initiatingClassName result = (initiatingClassName) em.find(initiatingClass, id);
        em.getTransaction().commit();
         
        return result;
	}

	@Override
	public Long countAll() {
		Session session = hem.getSession();
        Criteria crit = session.createCriteria(initiatingClass);
        session.getTransaction().begin();
        Integer resultInt = (Integer) crit.setProjection(Projections.rowCount()).uniqueResult();
        Long result = resultInt.longValue();
        session.getTransaction().commit();
        return result;
	}  
    
    
}
