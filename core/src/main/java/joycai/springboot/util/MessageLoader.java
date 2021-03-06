package joycai.springboot.util;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * 静态字符串加载工具
 */
public class MessageLoader {

    private static final String BUNDLE_NAME = "message";

    private static MessageLoader instance = null;

    public static MessageLoader getInstance() {
        if (instance == null) {
            instance = new MessageLoader();
        }
        return instance;
    }

    MessageSource messageSource;

    private MessageLoader() {
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename(BUNDLE_NAME);
        bundleMessageSource.setDefaultEncoding("UTF-8");
        this.messageSource = bundleMessageSource;
    }

    public String getMessage(final String key, final Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

    public String getMessageEn(final String key) {
        return getMessage(key, Locale.ENGLISH);
    }
}
