package com.pack.sooriya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatingTheObject {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			System.out.println("Updating the student object");
			Student myStudent = session.get(Student.class, 1);
			myStudent.setFirstName("Soorya");
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nUpdating the student object using query");
			session.createQuery("update Student s set s.email='soormo@gmail.com' where s.id=1").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
		
	}

}
