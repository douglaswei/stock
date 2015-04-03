package com.douglas.stock.common.seed;

import com.douglas.stock.common.seed.generator.StringGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgz on 15/4/1.
 */
public class SeedTemplate implements SeedInterface{
    private String templateSeed;
    private StringGenerator generator;
    private final static String templateStr = "${template}";

    public String getTemplateSeed() {
        return templateSeed;
    }

    public void setTemplateSeed(String templateSeed) {
        this.templateSeed = templateSeed;
    }

    public StringGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(StringGenerator generator) {
        this.generator = generator;
    }

    public static String getTemplateStr() {
        return templateStr;
    }

    @Override
    public List<String> getSeeds() {
        if (generator == null) {
            return null;
        }
        List<String> seeds = new ArrayList<String>();
        for (String entity : generator.getStrings()) {
            String seed = templateSeed.replace(templateStr, entity);
            seeds.add(seed);
        }
        return seeds;
    }
}
