package serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.GarbageService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class GarbageServiceImplTest {

    @Autowired
    GarbageService garbageService;

    @Test
    public void getGrabage() {
        System.out.println(garbageService.getGrabage("废书纸"));
    }

    @Test
    public void getGarbageTypes() {
    }

    @Test
    public void getGarbages() {
    }
}