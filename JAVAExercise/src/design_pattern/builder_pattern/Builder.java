package design_pattern.builder_pattern;

import design_pattern.factory_pattern.mutil_factory_pattern.MailSender;
import design_pattern.factory_pattern.mutil_factory_pattern.Sender;
import design_pattern.factory_pattern.mutil_factory_pattern.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-10-12.
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }

}
