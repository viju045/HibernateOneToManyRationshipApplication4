package org.mahagan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.model.Student;
import org.mahagan.model.Unversity;

import java.util.ArrayList;
import java.util.List;

public class OneToManyRelationshipApplicationHB4 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction txs = session.beginTransaction();

       //Student list of first unversity.
        Student student = new Student();
        student.setFirstName("Pratik");
        student.setLastName("Rane");
        student.setSection("Computer");

        Student student1 = new Student();
        student1.setFirstName("Suraj");
        student1.setLastName("Patil");
        student1.setSection("Mechanical");

        Student student2 = new Student();
        student2.setFirstName("Prajwal");
        student2.setLastName("Mahajan");
        student2.setSection("Computer");

        List<Student>list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);

        Unversity unversity = new Unversity();
        unversity.setUnversityName("Sppu");

        unversity.setStudents(list);
        session.persist(unversity);

        //Student list of Second unversity.
        Student student3 = new Student();
        student3.setFirstName("Siya");
        student3.setLastName("Khan");
        student3.setSection("IT");

        Student student4 = new Student();
        student4.setFirstName("Praju");
        student4.setLastName("Patil");
        student4.setSection("E&TC");

        Student student5 = new Student();
        student5.setFirstName("Rani");
        student5.setLastName("Roy");
        student5.setSection("Auto-Mobile");

        List<Student>list1 = new ArrayList<>();
        list1.add(student3);
        list1.add(student4);
        list1.add(student5);

        Unversity unversity1 = new Unversity();
        unversity1.setUnversityName("Shivaji Unversity");

        unversity1.setStudents(list1);
        session.persist(unversity1);

        //Student list of Third unversity.
        Student student6 = new Student();
        student6.setFirstName("Vijay");
        student6.setLastName("Mohite");
        student6.setSection("Computer");

        Student student7 = new Student();
        student7.setFirstName("Sumit");
        student7.setLastName("Patil");
        student7.setSection("Electrical");

        List<Student>list2 = new ArrayList<>();
        list2.add(student6);
        list2.add(student7);

        Unversity unversity2 = new Unversity();
        unversity2.setUnversityName("Mumbai Unversity");

        unversity2.setStudents(list2);
        session.persist(unversity2);

        txs.commit();
        session.close();

        System.out.println("Data Successfully inserted Ok!");
    }
}