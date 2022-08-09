package com.saran;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class One2One {

	public static void main(String[] args) {

		System.out.println("Hibernate One-To-One example (Annotation)");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
     //tansient state --start
		Address addr1 = new Address("13th Street", "Pittsburgh", "PA", "U.S.");
		
		Employee employee = new Employee("Vivek", "Antony", new Date(10-10-10),"114-857-922");
		employee.setEmployeeDetail(addr1);
		addr1.setEmployee(employee);
		//HQL->Hibernate Query Language
		List<Employee> employees = session.createQuery("from Employee").list();//HQL Hibernate Query Language
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstname() + " , "
					+ employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState()+employee1.getEmployeeDetail().getCity());
		}
		session.beginTransaction();
		System.out.println("b4 save");
		session.save(employee);
		System.out.println("after save");
		session.getTransaction().commit();

    	
		}
}
