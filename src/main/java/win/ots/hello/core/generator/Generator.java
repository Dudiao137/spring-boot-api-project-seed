package win.ots.hello.core.generator;

import com.greedystar.generator.invoker.SingleInvoker;
import com.greedystar.generator.invoker.base.Invoker;


/**
 * @author : sy.wang
 * @date : 20190929
 */
public class Generator {


    public static void main(String[] args) {
        Invoker invoker = new SingleInvoker.Builder()
                .setTableName("tbl_role")
                .setClassName("Role")
                .build();
        invoker.execute();
    }
}