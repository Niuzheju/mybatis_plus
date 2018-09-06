import com.baidu.dao.UserDao;
import com.baidu.model.User;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * mybatis plus 基本操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Test1 {

    @Autowired
    private UserDao userDao;

    /**
     * 新增数据
     */
    @Test
    public void test01() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1996, 7, 20);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        User user = new User("niuzj", "root", (int) (Math.random() * 100), calendar.getTime());
        Integer result = userDao.insert(user);
        System.out.println(result);
    }

    /**
     * 根据id更新
     */
    @Test
    public void test03() {
        User user = userDao.selectById(1);
        if (user == null) {
            return;
        }
        user.setUsername("root");
        Integer i = userDao.updateById(user);
        System.out.println(i);
    }

    /**
     * 根据id删除
     */
    @Test
    public void test02() {
        User user = userDao.selectById(1);
        if (user == null) {
            return;
        }
        Integer i = userDao.deleteById(user.getId());
        System.out.println(i);
    }

    /**
     * 根据id批量删除
     */
    @Test
    public void test04() {
        Integer i = userDao.deleteBatchIds(Arrays.asList(2, 3, 4));
        System.out.println(i);
    }

    /**
     * 查询
     */
    @Test
    public void test05() {
        User user = userDao.selectById(5);
        System.out.println("根据id查询" + user);
        List<User> users = userDao.selectBatchIds(Arrays.asList(5, 6));
        System.out.println("根据多个id查询" + users);
        Integer i = userDao.selectCount(new Condition().and("username={0}", "niuzj"));
        System.out.println("求和" + i);
        List<User> list = userDao.selectList(
                new EntityWrapper<User>()
                        .and("username={0}", "niuzj")
                        .gt("age", 75)
        );
        System.out.println("条件查询" + list);
    }

    /**
     * 使用自定义mapper
     */
    @Test
    public void test06(){
        Integer maxAge = userDao.getMaxAge();
        System.out.println(maxAge);
    }


}
