package com.example.hw17servlet.secondPartOfServlet.service;

import com.example.hw17servlet.secondPartOfServlet.entity.Person;
import com.example.hw17servlet.secondPartOfServlet.repository.PersonRepository;
import com.example.hw17servlet.secondPartOfServlet.repository.SessionFactorySingleton;
import org.hibernate.SessionFactory;

public class PersonService {
        private PersonRepository personRepository = new PersonRepository();
        private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();


        public Person add(Person person) {
            try (var session = sessionFactory.getCurrentSession()) {
                var transaction = session.getTransaction();
                try {
                    transaction.begin();
                    personRepository.add(person);
                    transaction.commit();
                    return person;
                } catch (Exception e) {
                    transaction.rollback();
                    System.out.println(e.getMessage());
                }
            }
            return null;
        }

        public void delete(Person person) {
            try (var session = sessionFactory.getCurrentSession()) {
                var transaction = session.getTransaction();
                try {
                    transaction.begin();
                    personRepository.delete(person);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    System.out.println(e.getMessage());
                }
            }
        }

        public void update(Person person) {
            try (var session = sessionFactory.getCurrentSession()) {
                var transaction = session.getTransaction();
                try {
                    transaction.begin();
                    personRepository.update(person);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    System.out.println(e.getMessage());
                }
            }
        }

        public Person findById(Integer id){
            try (var session = sessionFactory.getCurrentSession()) {
                var transaction = session.getTransaction();
                try {
                    transaction.begin();
                    Person returnedPerson = personRepository.findById(id);
                    transaction.commit();
                    return returnedPerson;
                } catch (Exception e) {
                    transaction.rollback();
                    System.out.println(e.getMessage());
                }
            }
            return null;
        }
    }
