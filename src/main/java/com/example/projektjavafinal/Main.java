package com.example.projektjavafinal;

import entity.UsersEntity;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Session session;
        session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();


        String login;
        String password;
        Scanner input = new Scanner(System.in);

        System.out.println("Podaj login ");
        login = input.next();
        input.nextLine();
        System.out.println("Podaj hasło");
        password = input.next();
        input.nextLine();

        Query query = session.createNamedQuery("LoginUser", UsersEntity.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<UsersEntity> result = query.getResultList();

        if (result.isEmpty()) {
            System.out.println("Wypierdalaj nie ma Cię w bazie");
        } else {
            System.out.printf("Elo ziom %s", result.get(0).getName());
        }

        session.close();

    }
}
