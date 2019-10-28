package win.ots.hello.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

/**
 * @author : sy.wang
 * @date : 20191010
 */
@Slf4j
@Component
public class TaskDbDemo implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addCronTask(
                () -> {
                    log.info("task from db : " + System.currentTimeMillis());
                },
                "0 0 1/1 * * ?");
    }
}
