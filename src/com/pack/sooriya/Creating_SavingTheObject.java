package com.pack.sooriya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Creating_SavingTheObject {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			System.out.println("Creating new student object");
			Student student = new Student("Kanishka","Devi","kanishka@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student object into the database");
			session.save(student);
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
		
		
	}

}
