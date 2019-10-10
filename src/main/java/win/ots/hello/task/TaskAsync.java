package win.ots.hello.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : sy.wang
 * @date : 20191010
 */
@Slf4j
@Component
public class TaskAsync {

    @Async
    @Scheduled(cron = "0 0 1/1 * * ?")
    public void sayHello() {
        log.info("hello, async " + System.currentTimeMillis());
    }

}
