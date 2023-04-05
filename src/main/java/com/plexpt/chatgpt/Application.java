package com.plexpt.chatgpt;


import com.plexpt.chatgpt.util.IpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        printKeyLoadMessage(context);

    }

    public static boolean printKeyLoadMessage(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        // 项目端口
        String port = environment.getProperty("server.port");
        // 项目路径
        String contextPath = environment.getProperty("server.servlet.context-path");

        String homeUrl = "http://" + IpUtils.getHostIp() + ":" + port + contextPath;

        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n            (♥◠‿◠)ﾉﾞ  启动成功   (♥◠‿◠)ﾉﾞ  \r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        System.out.println("\thomeUrl:    " + homeUrl);
        System.out.println("\r");

        return true;
    }

}