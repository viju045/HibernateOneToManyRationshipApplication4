package org.mahagan;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.model.Student;
import org.mahagan.model.Unversity;

import java.util.Iterator;
import java.util.List;

public class OneToManyRelationshipApplicationFetchDataHB4 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction txs = session.beginTransaction();

        TypedQuery query = session.createQuery("From Unversity unversity");
        List<Unversity>list = query.getResultList();
        Iterator<Unversity>iterator = list.listIterator();

        while(iterator.hasNext())
        {
            Unversity unversity = iterator.next();
            System.out.println(unversity.getUnversityName());

            List<Student>list1 = unversity.getStudents();
            Iterator<Student>iterator1 = list1.listIterator();
            while(iterator1.hasNext())
            {
                Student student = iterator1.next();
                System.out.println(student.getFirstName()+" "+student.getLastName()+" "+student.getSection());
            }
        }
        session.close();
        System.out.println("Data Fetch Syccessfylly. ok!");
    }
}
