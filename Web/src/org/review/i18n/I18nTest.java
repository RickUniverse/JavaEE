package org.review.i18n;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author lijichen
 * @date 2020/10/20 - 18:54
 */
public class I18nTest {
    @Test
    public void test() {
        Locale locale = Locale.US;
        Locale locale2 = Locale.CHINA;
//        Locale localeChina = Locale.CHINA;
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale2);
//        ResourceBundle bundle2 = ResourceBundle.getBundle("i18n", localeChina);

        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));
//        System.out.println(bundle2.getString("username"));
//        System.out.println(bundle2.getString("password"));
    }
}
