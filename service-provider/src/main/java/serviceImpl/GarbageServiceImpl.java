package serviceImpl;

import dao.GarbageDao;
import entity.Garbage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GarbageService;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class GarbageServiceImpl implements GarbageService {

    @Autowired
    GarbageDao garbageDao;

    @Override
    public void addGarbageType(String name) {
        garbageDao.addGarbageType(name);
    }

    @Override
    public void addGarbage(Garbage garbage) {
        garbageDao.addGarbage(garbage);
    }

    @Override
    public void delteGarbageType(String name) {
        garbageDao.delteGarbageType(name);
    }

    @Override
    public void deleteGarbage(Garbage garbage) {
        garbageDao.deleteGarbage(garbage);
    }

    @Override
    public Garbage getGrabage(String name) {
        return garbageDao.getGarbage(name);
    }

    @Override
    public List<String> getGarbageTypes() {
        return garbageDao.getGarbageTypes();
    }

    @Override
    public List<Garbage> getGarbages(String typeName) {
        return garbageDao.getGarbages(typeName);
    }
}
