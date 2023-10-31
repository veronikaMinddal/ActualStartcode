package org.example.controller.impl;

import org.example.config.HibernateConfig;

import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;
import org.example.controller.IController;
import org.example.dao.impl.Mock1Dao;
import org.example.model.Mock1;

public class Mock1Controller implements IController<Mock1, Integer>
{

    private final Mock1Dao dao;

    public Mock1Controller() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        this.dao = Mock1Dao.getInstance(emf);
    }

    @Override
    public void read(Context ctx)  {
    }

    @Override
    public void readAll(Context ctx) {
    }

    @Override
    public void create(Context ctx) {
    }

    @Override
    public void update(Context ctx) {
    }

    @Override
    public void delete(Context ctx) {
    }
}
