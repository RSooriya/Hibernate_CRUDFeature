package com.pack.sooriya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadingTheObject {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		int id=1;
		try
		{
			session.beginTransaction();
			System.out.println("Reading the student object");
			Student myStudent = session.get(Student.class, id); 
			session.getTransaction().commit();
			System.out.println(myStudent);
		}
		finally
		{
			factory.close();
		}
		
	}

}
