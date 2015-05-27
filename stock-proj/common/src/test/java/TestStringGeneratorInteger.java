import com.douglas.stock.common.seed.generator.StringGeneratorInteger;

/**
 * Created by wgz on 15/4/7.
 */
public class TestStringGeneratorInteger {
    public static void main(String[] args) {
        StringGeneratorInteger generatorInteger = new StringGeneratorInteger();
        generatorInteger.setBeg(10);
        generatorInteger.setEnd(20);
        for (String seed : generatorInteger.getStrings()) {
            System.out.println(seed);
        }
    }
}
