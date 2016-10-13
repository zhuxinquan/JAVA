package design_pattern.builder_pattern;

/**
 * Created by zhuxinquan on 16-10-12.
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
