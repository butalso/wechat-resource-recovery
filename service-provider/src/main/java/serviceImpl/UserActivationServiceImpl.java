package serviceImpl;

import dao.UserActivationDao;
import entity.User;
import entity.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserActivationService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserActivationServiceImpl implements UserActivationService {
    @Autowired
    UserActivationDao userActivationDao;

    @Override
    public void addActivation(User user, boolean logout) {
        String sdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        UserActivation userActivation = userActivationDao.getUserDateActivation(user.getId(), user.getUserKind(), sdate);
        if (userActivation == null) {
            userActivationDao.addActivation(user.getId(), user.getUserKind());
        } else {
            if (logout) {
                int duration = (int) ((new Date().getTime() - userActivation.getLastLoginTime().getTime()) / (1000 * 60));
                userActivation.setDuration(userActivation.getDuration() + duration);
            } else {
                userActivation.setLastLoginTime(new Date());
            }
            userActivationDao.updateActivation(userActivation);
        }
    }


    @Override
    public List<UserActivation> getUserActivations(User user) {
        return userActivationDao.getUserActivations(user.getId(), user.getUserKind());
    }

    @Override
    public List<UserActivation> getDateActivations(Date date) {
        return userActivationDao.getDateActivations(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }
}
