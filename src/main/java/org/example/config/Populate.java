package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.example.dao.impl.Mock1Dao;
import org.example.dao.impl.Mock2Dao;
import org.example.exception.ApiException;
import org.example.model.Mock1;
import org.example.model.Mock2;
import java.util.List;

public class Populate
    //til dele uden database. Set entities ind her som et slags mock database. kald dine populate funktioner. bliver kun måske relevant.
{
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private static final Mock1Dao mock1Dao = Mock1Dao.getInstance(emf);
    private static final Mock2Dao mock2Dao = Mock2Dao.getInstance(emf);
    public static void main(String[] args)
    {
        List<Mock1> mock1s = populateMock1();
        List<Mock2> mock2s = populateMock2();
        try
        {
            for (Mock1 mock1 : mock1s)
            {
                mock1Dao.create(mock1);
            }
            for (Mock2 mock2 : mock2s)
            {
                mock2Dao.create(mock2);
            }
        }catch (ApiException e)
        {
            System.out.println("Something went wrong");
        }
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
        Mock2 Faraos = new Mock2(2, "Faraos");
        Mock2 Kelzor = new Mock2(3, "Kelzor");
        Mock2 CardMarket = new Mock2(4, "CardMarket");

        return List.of(Walmart, Faraos, Kelzor, CardMarket);
    }
}