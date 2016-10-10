package design_pattern.factory_pattern.abstract_factory_pattern;

import design_pattern.factory_pattern.mutil_factory_pattern.MailSender;
import design_pattern.factory_pattern.mutil_factory_pattern.Sender;

/**
 * Created by zhuxinquan on 16-10-10.
 */
public class SendMailFactory implements Provider{
    @Override
    public Sender produce(){
        return new MailSender();
    }
}
