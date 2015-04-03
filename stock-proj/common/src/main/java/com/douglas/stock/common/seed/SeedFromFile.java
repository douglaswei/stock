package com.douglas.stock.common.seed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgz on 15/3/30.
 */
public class SeedFromFile implements SeedInterface {
    private static final Logger logger = LoggerFactory.getLogger(SeedFromFile.class);
    private String filename;

    @Override
    public List<String> getSeeds() {
        List<String> seeds = new ArrayList<String>();
        BufferedReader br = null;
        try {
            URL url = getClass().getResource(filename);
            br = new BufferedReader(new FileReader(url.getPath()));
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.length() > 1) {
                    seeds.add(line.trim());
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("{}", e);
            logger.error("{}", e);
        } catch (IOException e) {
            logger.error("{}", e);
            logger.error("{}", e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                logger.error("{}", e);
                logger.error("{}", e);
            }
        }
        return seeds;
    }
}
