package com.douglas.stock.common.seed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgz on 15/3/30.
 */
public class SeedManager {
    List<SeedInterface> seedTemplates;

    public List<SeedInterface> getSeedTemplates() {
        return seedTemplates;
    }

    public void setSeedTemplates(List<SeedInterface> seedTemplates) {
        this.seedTemplates = seedTemplates;
    }

    public List<String> getSeeds() {
        List<String> seeds = new ArrayList<String>();
        for (SeedInterface seedTemplate : seedTemplates) {
            seeds.addAll(seedTemplate.getSeeds());
        }
        return seeds;
    }
}
