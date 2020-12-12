package joycai.springboot.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class MessageLoaderTest {

    @Test
    void test() {
        MessageLoader messageLoader = MessageLoader.getInstance();
        Assertions.assertEquals("测试", messageLoader.getMessage("default", Locale.CHINA));
        Assertions.assertEquals("test", messageLoader.getMessageEn("default"));
    }
}
