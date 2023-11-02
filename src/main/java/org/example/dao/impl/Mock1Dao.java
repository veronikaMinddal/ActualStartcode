package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.dao.IDao;
import org.example.exception.ApiException;
import org.example.model.Mock1;
import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Mock1Dao implements IDao<Mock1, Integer>
{
    private static Mock1Dao instance;
    private static EntityManagerFactory emf;

    public static Mock1Dao getInstance(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new Mock1Dao();
        }
        return instance;
    }

    @Override
    public Mock1 read(Integer id) throws ApiException
    {
        if(!validateId(id))
        {
            throw new ApiException(404, "Id does not exist");
        }
        try (var em = emf.createEntityManager())
        {
            return em.find(Mock1.class, id);
        }
    }

    @Override
    public List<Mock1> readAll()
    {
        try (var em = emf.createEntityManager())
        {
            var query = em.createQuery("SELECT m1 FROM Mock1 m1", Mock1.class);
            return query.getResultList();
        }
    }

    @Override
    public Mock1 create(Mock1 mock1) throws ApiException
    {
        try (var em = emf.createEntityManager())
        {
            if(!mock1.validateNewMock1()) {throw new ApiException(400, "Mock1 is not valid");}
                em.getTransaction().begin();
                em.persist(mock1);
                em.getTransaction().commit();
                return mock1;
        }

    }

    @Override
    public Mock1 update(Integer id, Mock1 updated) throws ApiException
    {
        if (!validateId(id)) {throw new ApiException(404, "Id does not exist");} else
        {
            try (var em = emf.createEntityManager())
            {
                em.getTransaction().begin();

                var mock1 = em.find(Mock1.class, id);
                mock1.setMock1String(updated.getMock1String());
                mock1.setMock1Number(updated.getMock1Number());
                Mock1 merge = em.merge(mock1);
                em.getTransaction().commit();
                return merge;
            }
        }
    }

    @Override
    public void delete(Integer id) throws ApiException
    {
        if (!validateId(id)) {throw new ApiException(404,"Id does not exist");}
        try(var em = emf.createEntityManager())
        {
            em.getTransaction().begin();
            var mock1 = em.find(Mock1.class, id);
            em.remove(mock1);
            em.getTransaction().commit();
        }
    }

    public boolean validateId(Integer id)
    {
        try(EntityManager em = emf.createEntityManager())
        {
            TypedQuery<Integer> query = em.createQuery("SELECT m1.id FROM Mock1 m1", Integer.class);
            return query.getResultList().contains(id);
        }
    }
}