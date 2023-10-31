package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.example.dao.impl.Mock1Dao;
import org.example.dao.impl.Mock2Dao;
import org.example.model.Mock1;
import org.example.model.Mock2;

import java.util.List;

public class Populate
{
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private static Mock1Dao mock1Dao = Mock1Dao.getInstance(emf);
    private static Mock2Dao mock2Dao = Mock2Dao.getInstance(emf);
    public static void main(String[] args)
    {
        List<Mock1> mock1s = populateMock1();
        List<Mock2> mock2s = populateMock2();
        mock1s.forEach(mock1 -> mock1Dao.create(mock1));
        mock2s.forEach(mock2 -> mock2Dao.create(mock2));
    }

    public static List<Mock1> populateMock1()
    {
        //Pretending mock1 is cards
        Mock1 blueEyesWhiteDragon = new Mock1("Blue Eyes White Dragon", 8);
        Mock1 darkMagician = new Mock1("Dark Magician", 7);
        Mock1 redEyesBlackDragon = new Mock1("Red Eyes Black Dragon", 7);
        Mock1 blueEyesUltimateDragon = new Mock1("Blue Eyes Ultimate Dragon", 12);
        return List.of(blueEyesWhiteDragon, darkMagician, redEyesBlackDragon, blueEyesUltimateDragon);
    }
    public static List<Mock2> populateMock2()
    {
        //Pretending mock1 is vendors
        Mock2 Walmart = new Mock2(1, "Walmart");
        Mock2 Target = new Mock2(2, "Target");
        Mock2 GameStop = new Mock2(3, "GameStop");
        Mock2 BestBuy = new Mock2(4, "Best Buy");

        return List.of(Walmart, Target, GameStop, BestBuy);
    }
}