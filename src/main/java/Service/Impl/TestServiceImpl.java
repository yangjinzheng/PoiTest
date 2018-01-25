package Service.Impl;/**
 * Created by pc on 2018/1/25.
 */
import Vo.Test;
import Dao.TestDao;
import Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/01/25
 */
@Service("TestService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> list() {
        return testDao.list();
    }
}
