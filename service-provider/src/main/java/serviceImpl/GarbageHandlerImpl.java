package serviceImpl;

import dao.GarbageDao;
import entity.Garbage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GarbageHandler;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class GarbageHandlerImpl implements GarbageHandler {

    @Autowired
    GarbageDao garbageDao;

    @Override
    public List<String> getGarbageTypes() {
        return null;
    }

    @Override
    public List<Garbage> getGarbages(String typeName) {
        return garbageDao.getGarbages(typeName);
    }
}
