package startProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String args[]) throws IOException {
        Logger logger = LoggerFactory.getLogger(App.class);
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-provider.xml"});
            context.start();
        } catch (Exception e) {
            logger.error("dubbo provider start fail", e);
        }

        // press any key to exit
        System.in.read();
    }
}
