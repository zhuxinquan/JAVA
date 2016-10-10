package design_pattern.factory_pattern.abstract_factory_pattern;

import design_pattern.factory_pattern.mutil_factory_pattern.Sender;
import design_pattern.factory_pattern.mutil_factory_pattern.SmsSender;

/**
 * Created by zhuxinquan on 16-10-10.
 */
public class SendSmsFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
