package org.hibernates;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //get-student
        //get() method of hibernate session return n ull if object is not found in cache as well as on database.
        //Use if you are not sure that object exists in db or not.
        //get() involves database hit if object doesn't exist in session cache and return a fully initialized object which may involve several database call.
        Student student1 = (Student)session.get(Student.class, 101);
        System.out.println(student1);

        //load-student
        //load() method throw  ObjectNotFoundException if object not found on cache as well as on database but never return null.
        //Use if you are sure that object exists.
        //load method can return proxy in place and only initialize the object or hit the database if any method other than getId() is called on persistent or entity object, This lazy initialization increases the performance.
        Student student2 = (Student)session.load(Student.class, 102);
        System.out.println(student2);

        session.close();
        sessionFactory.close();
    }
}
