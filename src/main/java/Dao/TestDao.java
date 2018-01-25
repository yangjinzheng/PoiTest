package Dao;

import org.apache.ibatis.io.ResolverUtil;
import Vo.Test;

import java.util.List;

/**
 * Created by pc on 2018/1/25.
 */
public interface TestDao {
    public List<Test> list();
}
