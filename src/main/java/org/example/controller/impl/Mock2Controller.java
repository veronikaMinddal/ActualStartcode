package org.example.controller.impl;

import org.example.config.HibernateConfig;
import org.example.controller.IController;
import org.example.dao.impl.Mock2Dao;
import org.example.model.Mock2;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;


public class Mock2Controller implements IController<Mock2, Integer>
{
    private Mock2Dao dao;
    public Mock2Controller()
    {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        this.dao = Mock2Dao.getInstance(emf);
    }
    @Override
    public void read(Context ctx)
    {
    }
    @Override
    public void readAll(Context ctx)
    {
    }

    @Override
    public void create(Context ctx)
    {
    }
    @Override
    public void update(Context ctx)
    {
    }
    @Override
    public void delete(Context ctx)
    {
    }
}