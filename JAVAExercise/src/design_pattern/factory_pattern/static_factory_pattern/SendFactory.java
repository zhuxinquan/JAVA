package design_pattern.factory_pattern.static_factory_pattern;

import design_pattern.factory_pattern.mutil_factory_pattern.MailSender;
import design_pattern.factory_pattern.mutil_factory_pattern.Sender;
import design_pattern.factory_pattern.mutil_factory_pattern.SmsSender;

/**
 * Created by zhuxinquan on 16-10-10.
 */
public class SendFactory {
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
