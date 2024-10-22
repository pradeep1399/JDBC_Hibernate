package org.hibernates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Project Started....");


        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); //put name file name if it is not "hibernate.cfg.xml"
        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();

        //creating student
        Student st = new Student();
        st.setId(101);
        st.setName("Pradeep");
        st.setCity("Bangalore");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();

        session.close();
    }
}