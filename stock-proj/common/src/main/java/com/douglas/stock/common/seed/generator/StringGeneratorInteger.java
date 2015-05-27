package com.douglas.stock.common.seed.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgz on 15/4/7.
 */
public class StringGeneratorInteger implements StringGenerator {
    private int beg;
    private int end;
    private int fixedWidth = 6;

    public int getBeg() {
        return beg;
    }

    public void setBeg(int beg) {
        this.beg = beg;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public List<String> getStrings() {
        List<String> seeds = new ArrayList<String>();
        for (int idx = beg; idx <= end; ++idx) {
            String feed = String.format("%06d", idx);
            seeds.add(feed);
        }
        return seeds;
    }
}
