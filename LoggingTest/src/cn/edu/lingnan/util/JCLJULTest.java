package cn.edu.lingnan.util;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
//import org.apache.commons.Logging.Log;
//import org.apache.commons.Logging.LogFactory;

public class JCLJULTest {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(JCLJULTest.class.getName());
        log.info(String.valueOf(log.getClass()));
        log.info("门面框架JCL整合JUL输出");
    }
}
