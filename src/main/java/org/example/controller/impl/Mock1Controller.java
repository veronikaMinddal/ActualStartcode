package org.example.controller.impl;

import org.example.config.HibernateConfig;

import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;
import org.example.controller.IController;
import org.example.dao.impl.Mock1Dao;
import org.example.dto.Mock1Dto;
import org.example.exception.Message;
import org.example.model.Mock1;

import java.util.List;

public class Mock1Controller implements IController<Mock1, Integer>
{

    private final Mock1Dao dao;

    public Mock1Controller() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        this.dao = Mock1Dao.getInstance(emf);
    }

    @Override
    public void read(Context ctx)
    {// request
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        // entity
        Mock1 mock1 = dao.read(id);
        // dto
        Mock1Dto mock1Dto = new Mock1Dto(mock1);
        // response
        ctx.res().setStatus(200);
        ctx.json(mock1, Mock1.class);
    }

    @Override
    public void readAll(Context ctx)
    {
        // entity
        List<Mock1> mock1s = dao.readAll();
        // dto
        List<Mock1Dto> mock1Dtos = Mock1Dto.toMock1DtoList(mock1s);
        // response
        ctx.res().setStatus(200);
        ctx.json(mock1Dtos, Mock1Dto.class);
    }

    @Override
    public void create(Context ctx)
    {
        // request
        Mock1 jsonRequest = validateEntity(ctx);

        // entity
        Mock1 mock1 = dao.create(jsonRequest);
        // dto
        Mock1Dto mock1Dto = new Mock1Dto(mock1);
        // response
        ctx.res().setStatus(201);
        ctx.json(mock1Dto, Mock1Dto.class);
    }

    @Override
    public void update(Context ctx)
    {
        // request

        Mock1 jsonRequest = validateEntity(ctx);
        // entity
        Mock1 mock1 = dao.update(jsonRequest.getId(), jsonRequest);
        // dto
        Mock1Dto mock1Dto = new Mock1Dto(mock1);
        // response
        ctx.res().setStatus(200);
        ctx.json(mock1Dto, Mock1Dto.class);
    }

    @Override
    public void delete(Context ctx)
    {
        // request
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        // entity
        dao.delete(id);
        // response
        ctx.res().setStatus(204);
    }

    public Mock1 validateEntity(Context ctx) {
        return ctx.bodyValidator(Mock1.class)
                .check(m1 -> m1.getMock1String() != null && !m1.getMock1String().isEmpty(), "Name cannot be empty or null")
                .check(m1 -> m1.getMock1Number() > 0 && m1.getMock1Number() < 13, "Number must be between (including) 1 and 12")
                .get();
    }

    public boolean validatePrimaryKey(Integer id)
    {
        return id > 0;
    }
}
