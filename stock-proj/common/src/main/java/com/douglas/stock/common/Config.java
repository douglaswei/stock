package com.douglas.stock.common;

import com.douglas.stock.common.dao.DBRecordService;

import java.io.BufferedWriter;

/**
 * Created by wgz on 15/4/10.
 */
public class Config {
    private static int maxThreadNum = 400;
    private static int trainWindow = 100;
    private static int labelWindow = 10;
    private static String featFileName = "feats";
    private static DBRecordService service;
    private static float labelThresholdUpper = 5;
    private static float labelThresholdLower = -5;
    private static float exceptionUppder = 80;
    private static float exceptionLower = -80;
    private static BufferedWriter bufferedWriter;

    public static DBRecordService getService() {
        return service;
    }

    public static void setService(DBRecordService service) {
        Config.service = service;
    }

    public static int getMaxThreadNum() {
        return maxThreadNum;
    }

    public static void setMaxThreadNum(int maxThreadNum) {
        Config.maxThreadNum = maxThreadNum;
    }

    public static int getTrainWindow() {
        return trainWindow;
    }

    public static void setTrainWindow(int trainWindow) {
        Config.trainWindow = trainWindow;
    }

    public static int getLabelWindow() {
        return labelWindow;
    }

    public static void setLabelWindow(int labelWindow) {
        Config.labelWindow = labelWindow;
    }

    public static int getWindow() {
        return getTrainWindow() + getLabelWindow();
    }

    public static String getFeatFileName() {
        return featFileName;
    }

    public static void setFeatFileName(String featFileName) {
        Config.featFileName = featFileName;
    }

    public static float getLabelThresholdUpper() {
        return labelThresholdUpper;
    }

    public static void setLabelThresholdUpper(float labelThresholdUpper) {
        Config.labelThresholdUpper = labelThresholdUpper;
    }

    public static float getLabelThresholdLower() {
        return labelThresholdLower;
    }

    public static void setLabelThresholdLower(float labelThresholdLower) {
        Config.labelThresholdLower = labelThresholdLower;
    }

    public static float getExceptionUppder() {
        return exceptionUppder;
    }

    public static void setExceptionUppder(float exceptionUppder) {
        Config.exceptionUppder = exceptionUppder;
    }

    public static float getExceptionLower() {
        return exceptionLower;
    }

    public static void setExceptionLower(float exceptionLower) {
        Config.exceptionLower = exceptionLower;
    }

    public static BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public static void setBufferedWriter(BufferedWriter bufferedWriter) {
        Config.bufferedWriter = bufferedWriter;
    }
}
