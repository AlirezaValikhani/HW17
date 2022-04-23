package com.example.hw17servlet.secondPartOfServlet.repository;


import com.example.hw17servlet.secondPartOfServlet.entity.Person;
import org.hibernate.SessionFactory;

public class PersonRepository {
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

        public Person add(Person person) {
            var session = sessionFactory.getCurrentSession();
            session.save(person);
            return person;
        }

        public Person update(Person person) {
            var session = sessionFactory.getCurrentSession();
            session.update(person);
            return person;
        }

        public void delete(Person person) {
            var session = sessionFactory.getCurrentSession();
            session.delete(person);
        }

        public Person findById(Integer id) {
            var session = sessionFactory.getCurrentSession();
            return session
                    .createQuery("select p from Person p where p.id = :id",Person.class)
                    .setParameter("id",id)
                    .getSingleResult();
        }
    }
