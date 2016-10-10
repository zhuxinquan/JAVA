package design_pattern.factory_pattern.mutil_factory_pattern;

/**
 * Created by zhuxinquan on 16-10-10.
 */
public class SendFactory {
    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
