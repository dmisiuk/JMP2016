import com.epam.jmp.context.YamlApplicationContext;
import com.epam.jmp.model.Director;
import com.epam.jmp.model.Shop;
import com.epam.jmp.model.Warehouse;
import com.sun.jnlp.ApiDialog;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzmitry_Misiuk on 7/25/2016.
 */
public class TestInitializing {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        //applicationContext = new YamlApplicationContext("/context.yaml");
        applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
    }


    @Test
    public void testInit() {
        Director director = (Director) applicationContext.getBean("director");
        Assert.assertNotNull(director);
        Assert.assertEquals("Dzmitry", director.getName());
        Assert.assertEquals(28, director.getAge());

        Shop shop = (Shop) applicationContext.getBean("shop");
        Assert.assertNotNull(shop);

        Warehouse warehouse = shop.getWarehouse();
        Assert.assertNotNull(warehouse);
        Assert.assertEquals("Minsk", warehouse.getAddress());

        Assert.assertNotNull(warehouse.getEmployees());
        Assert.assertEquals(3, warehouse.getEmployees().size());

        Assert.assertTrue(warehouse.getEmployees().contains(director));

    }
}
