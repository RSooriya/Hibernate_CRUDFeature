package com.pack.sooriya;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryingTheObject {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			System.out.println("Retrieving all student objects");
			List<Student> theStudent = session.createQuery("from Student").list();
		    displayStudents(theStudent);
		    System.out.println("\n\nRetrieving student object whose name ends with Meenakshi");
		    theStudent = session.createQuery("from Student s where s.lastName = 'Meenakshi'").list();
		    displayStudents(theStudent);
		    System.out.println("\n\nRetrieving student object whose name starts with Sooriya or Shama");
		    theStudent = session.createQuery("from Student s where s.firstName = 'Sooriya' or s.firstName = 'Shama'").list();
		    displayStudents(theStudent);
            System.out.println("\n\nRetrieving student object whose email ends with '06@gmail.com'");
            theStudent = session.createQuery("from Student s where s.email like '%06@gmail.com'").list();
		    displayStudents(theStudent);
            session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student myStudent:theStudent)
		{
			System.out.println(myStudent);
		}
	}

}
