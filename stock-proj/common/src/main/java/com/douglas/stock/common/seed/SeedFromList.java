package com.douglas.stock.common.seed;

import java.util.List;

/**
 * Created by wgz on 15/4/1.
 */
public class SeedFromList implements SeedInterface {
    private List<String> seeds;

    public void setSeeds(List<String> seeds) {
        this.seeds = seeds;
    }

    @Override
    public List<String> getSeeds() {
        return seeds;
    }
}
