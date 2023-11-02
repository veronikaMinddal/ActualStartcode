package org.example.dao.impl;

import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import org.example.dao.IDao;
import org.example.model.Mock2;

import java.util.List;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Mock2Dao implements IDao<Mock2, Integer>
{

    private static Mock2Dao instance;
    private static EntityManagerFactory emf;

    public static Mock2Dao getInstance(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new Mock2Dao();
        }
        return instance;
    }

    @Override
    public Mock2 read(Integer id)
    {
        try (var em = emf.createEntityManager())
        {
            return em.find(Mock2.class, id);
        }
    }

    @Override
    public List<Mock2> readAll()
    {
        try (var em = emf.createEntityManager())
        {
            var query = em.createQuery("SELECT m2 FROM Mock2 m2", Mock2.class);
            return query.getResultList();
        }
    }

    @Override
    public Mock2 create(Mock2 mock2)
    {
        try (var em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            em.persist(mock2);
            em.getTransaction().commit();
            return mock2;
        }
    }

    @Override
    public Mock2 update(Integer integer, Mock2 mock2)
    {
        try (var em = emf.createEntityManager())
        {
            em.getTransaction().begin();

            var m2 = em.find(Mock2.class, integer);
            m2.setMock2Name(mock2.getMock2Name());
            m2.setMock2Number(mock2.getMock2Number());

            Mock2 merge = em.merge(m2);
            em.getTransaction().commit();
            return merge;
        }
    }

    @Override
    public void delete(Integer id)
    {
        try (var em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            var mock2 = em.find(Mock2.class, id);
            em.remove(mock2);
            em.getTransaction().commit();
        }
    }
}