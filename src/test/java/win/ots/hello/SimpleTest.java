package win.ots.hello;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.ots.hello.dao.UserRepository;
import win.ots.hello.entity.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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


    @Test
    public void testMd5() {
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1024;
//        ByteSource credentialsSalt = ByteSource.Util.bytes("user");
        String credentialsSalt = UUID.randomUUID().toString();
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);

        /*098d2c478e9c11555ce2823231e02ec1*/
    }

}
