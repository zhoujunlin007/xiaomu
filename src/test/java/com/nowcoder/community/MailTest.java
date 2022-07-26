package com.nowcoder.community;


import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)   // 设置配置类
public class MailTest {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testMail() {
        mailClient.sendMail("xiaomu9178@qq.com", "test", "成功");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "xiaomu");

        String content = templateEngine.process("/mail/demo", context);// 调用thymeleaf模板，填充内容
        System.out.println(content);

        mailClient.sendMail("xiaomu9178@qq.com", "HTML", content);
    }

}
