package design_pattern.factory_pattern.abstract_factory_pattern;

import design_pattern.factory_pattern.mutil_factory_pattern.Sender;

/**
 * Created by zhuxinquan on 16-10-10.
 * 为工厂类提供一个统一的接口
 */
public interface Provider {
    public Sender produce();
}
