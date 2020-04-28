package com.pack.sooriya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletingTheObject {

	public static void main(String[] args) {
      
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			System.out.println("Deleting the object");
			Student myStudent = session.get(Student.class, 1);
			session.delete(myStudent);
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Deleting the object using query");
			session.createQuery("delete from Student where id=4").executeUpdate();
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
