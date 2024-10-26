package org.map;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("what is java ?");

        Question q2 = new Question();
        q2.setQuestionId(1414);
        q2.setQuestion("what is collection framework ?");

        //creating answer
        Answer a1 = new Answer();
        a1.setAnswerId(232);
        a1.setAnswer("Java is programming language.");
        q1.setAnswer(a1);
        a1.setQuestion(q1);

        Answer a2 = new Answer();
        a2.setAnswerId(424);
        a2.setAnswer("API to work with objects in Java.");
        q2.setAnswer(a2);
        a2.setQuestion(q2);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(q1);
        session.save(a1);
        session.save(q2);
        session.save(a2);
        transaction.commit();
        session.close();
    }
}
