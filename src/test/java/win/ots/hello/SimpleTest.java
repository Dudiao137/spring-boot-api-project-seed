package win.ots.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.ots.hello.dao.UserRepository;
import win.ots.hello.entity.User;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SimpleTest {



    @Resource
    private UserRepository userRepository;



    @Test
    public void testGenerator() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }
}
