package design_pattern.factory_pattern.mutil_factory_pattern;

/**
 * Created by zhuxinquan on 16-10-10.
 */
public class MailSender implements Sender{
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}
