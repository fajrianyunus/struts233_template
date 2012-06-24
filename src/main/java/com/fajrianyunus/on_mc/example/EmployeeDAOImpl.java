package com.fajrianyunus.on_mc.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManagerFactory emf;
    private EntityManager em;
    private HibernateEntityManager hem;	
    
    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
        hem = (HibernateEntityManager) em;
    }       

	@Override
	public List<Employee> getAllEmployees() {
		Session session = hem.getSession();
        Criteria crit = session.createCriteria(Employee.class);
        session.getTransaction().begin();
        List<Employee> result = crit.list();
        session.getTransaction().commit();		
        return result;
	}

	@Override
	public void saveEmployee(Employee e) {
		Session session = hem.getSession();
        session.getTransaction().begin();
        session.saveOrUpdate(e);
        session.getTransaction().commit();
	}

}
