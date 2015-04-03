package com.douglas.stock.crawler.dao;

import java.util.Date;

/**
 * Created by wgz on 15/3/30.
 */
public class DBRecord {
    String code;
    Date date;
    float ma;
    float maGradient;       // unit percent
    float hsl;              // unit percent
    float ddx;
    float bbd;              // unit: 10,000
    float liuTongShiZhi;    // unit: 100,000,000

    float jinLiuru;         // unit: 10,000
    float cashStrength1;    // unit: percent
    float cashStrength3;
    float cashStrength5;
    float cashStrength10;
    int cashRed3;           // unit: day
    int cashRed5;
    int cashRed10;
    int cashRed20;

    float hdJingLiang;      // unit: vol
    float hdCashStrength1;  // unit: percent
    float hdCashStrength3;
    float hdCashStrength5;
    float hdCashStrength10;
    int hdCashRed3;         // unit: day
    int hdCashRed5;
    int hdCashRed10;
    int hdCashRed20;

    float ddy;
    float ddz;
    int net;                // unit: 10,000
    int diffActionXBig;           // unit: vol
    int diffActionBig;
    int diffActionMid;
    int diffActionSmall;
    float strength;
    float activeRate;
    float takeRate;
    float diffActionPercentXBig;
    float diffActionPercentBig;
    float diffActionPercentMid;
    float diffActionPercentSmall;
    float activity;
    float volRatio;
    float ddx5;
    float ddy5;
    float ddx60;
    float ddy60;
    int ddxRed10Count;
    int ddxRed10Continue;
    int smallVolChaShou;
    int ziJinQiangdu;
    int volIn;
    int volOut;
    int avgVolIn;
    int avgVolOut;
    int cumulateSmall;
    int cumulateNet;
    float inPercentXLarge;
    float outPercentXLarge;
    float inPercentLarge;
    float outPercentLarge;
    float inPercentMid;
    float outPercentMid;
    float inPercentSmall;
    float outPercentSmall;
    float liangBi;
    float peRatio;
    float pePs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMa() {
        return ma;
    }

    public void setMa(float ma) {
        this.ma = ma;
    }

    public float getMaGradient() {
        return maGradient;
    }

    public void setMaGradient(float maGradient) {
        this.maGradient = maGradient;
    }

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }

    public float getDdx() {
        return ddx;
    }

    public void setDdx(float ddx) {
        this.ddx = ddx;
    }

    public float getBbd() {
        return bbd;
    }

    public void setBbd(float bbd) {
        this.bbd = bbd;
    }

    public float getLiuTongShiZhi() {
        return liuTongShiZhi;
    }

    public void setLiuTongShiZhi(float liuTongShiZhi) {
        this.liuTongShiZhi = liuTongShiZhi;
    }

    public float getJinLiuru() {
        return jinLiuru;
    }

    public void setJinLiuru(float jinLiuru) {
        this.jinLiuru = jinLiuru;
    }

    public float getCashStrength1() {
        return cashStrength1;
    }

    public void setCashStrength1(float cashStrength1) {
        this.cashStrength1 = cashStrength1;
    }

    public float getCashStrength3() {
        return cashStrength3;
    }

    public void setCashStrength3(float cashStrength3) {
        this.cashStrength3 = cashStrength3;
    }

    public float getCashStrength5() {
        return cashStrength5;
    }

    public void setCashStrength5(float cashStrength5) {
        this.cashStrength5 = cashStrength5;
    }

    public float getCashStrength10() {
        return cashStrength10;
    }

    public void setCashStrength10(float cashStrength10) {
        this.cashStrength10 = cashStrength10;
    }

    public int getCashRed3() {
        return cashRed3;
    }

    public void setCashRed3(int cashRed3) {
        this.cashRed3 = cashRed3;
    }

    public int getCashRed5() {
        return cashRed5;
    }

    public void setCashRed5(int cashRed5) {
        this.cashRed5 = cashRed5;
    }

    public int getCashRed10() {
        return cashRed10;
    }

    public void setCashRed10(int cashRed10) {
        this.cashRed10 = cashRed10;
    }

    public int getCashRed20() {
        return cashRed20;
    }

    public void setCashRed20(int cashRed20) {
        this.cashRed20 = cashRed20;
    }

    public float getHdJingLiang() {
        return hdJingLiang;
    }

    public void setHdJingLiang(float hdJingLiang) {
        this.hdJingLiang = hdJingLiang;
    }

    public float getHdCashStrength1() {
        return hdCashStrength1;
    }

    public void setHdCashStrength1(float hdCashStrength1) {
        this.hdCashStrength1 = hdCashStrength1;
    }

    public float getHdCashStrength3() {
        return hdCashStrength3;
    }

    public void setHdCashStrength3(float hdCashStrength3) {
        this.hdCashStrength3 = hdCashStrength3;
    }

    public float getHdCashStrength5() {
        return hdCashStrength5;
    }

    public void setHdCashStrength5(float hdCashStrength5) {
        this.hdCashStrength5 = hdCashStrength5;
    }

    public float getHdCashStrength10() {
        return hdCashStrength10;
    }

    public void setHdCashStrength10(float hdCashStrength10) {
        this.hdCashStrength10 = hdCashStrength10;
    }

    public int getHdCashRed3() {
        return hdCashRed3;
    }

    public void setHdCashRed3(int hdCashRed3) {
        this.hdCashRed3 = hdCashRed3;
    }

    public int getHdCashRed5() {
        return hdCashRed5;
    }

    public void setHdCashRed5(int hdCashRed5) {
        this.hdCashRed5 = hdCashRed5;
    }

    public int getHdCashRed10() {
        return hdCashRed10;
    }

    public void setHdCashRed10(int hdCashRed10) {
        this.hdCashRed10 = hdCashRed10;
    }

    public int getHdCashRed20() {
        return hdCashRed20;
    }

    public void setHdCashRed20(int hdCashRed20) {
        this.hdCashRed20 = hdCashRed20;
    }

    public float getDdy() {
        return ddy;
    }

    public void setDdy(float ddy) {
        this.ddy = ddy;
    }

    public float getDdz() {
        return ddz;
    }

    public void setDdz(float ddz) {
        this.ddz = ddz;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public int getDiffActionXBig() {
        return diffActionXBig;
    }

    public void setDiffActionXBig(int diffActionXBig) {
        this.diffActionXBig = diffActionXBig;
    }

    public int getDiffActionBig() {
        return diffActionBig;
    }

    public void setDiffActionBig(int diffActionBig) {
        this.diffActionBig = diffActionBig;
    }

    public int getDiffActionMid() {
        return diffActionMid;
    }

    public void setDiffActionMid(int diffActionMid) {
        this.diffActionMid = diffActionMid;
    }

    public int getDiffActionSmall() {
        return diffActionSmall;
    }

    public void setDiffActionSmall(int diffActionSmall) {
        this.diffActionSmall = diffActionSmall;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public float getActiveRate() {
        return activeRate;
    }

    public void setActiveRate(float activeRate) {
        this.activeRate = activeRate;
    }

    public float getTakeRate() {
        return takeRate;
    }

    public void setTakeRate(float takeRate) {
        this.takeRate = takeRate;
    }

    public float getDiffActionPercentXBig() {
        return diffActionPercentXBig;
    }

    public void setDiffActionPercentXBig(float diffActionPercentXBig) {
        this.diffActionPercentXBig = diffActionPercentXBig;
    }

    public float getDiffActionPercentBig() {
        return diffActionPercentBig;
    }

    public void setDiffActionPercentBig(float diffActionPercentBig) {
        this.diffActionPercentBig = diffActionPercentBig;
    }

    public float getDiffActionPercentMid() {
        return diffActionPercentMid;
    }

    public void setDiffActionPercentMid(float diffActionPercentMid) {
        this.diffActionPercentMid = diffActionPercentMid;
    }

    public float getDiffActionPercentSmall() {
        return diffActionPercentSmall;
    }

    public void setDiffActionPercentSmall(float diffActionPercentSmall) {
        this.diffActionPercentSmall = diffActionPercentSmall;
    }

    public float getActivity() {
        return activity;
    }

    public void setActivity(float activity) {
        this.activity = activity;
    }

    public float getVolRatio() {
        return volRatio;
    }

    public void setVolRatio(float volRatio) {
        this.volRatio = volRatio;
    }

    public float getDdx5() {
        return ddx5;
    }

    public void setDdx5(float ddx5) {
        this.ddx5 = ddx5;
    }

    public float getDdy5() {
        return ddy5;
    }

    public void setDdy5(float ddy5) {
        this.ddy5 = ddy5;
    }

    public float getDdx60() {
        return ddx60;
    }

    public void setDdx60(float ddx60) {
        this.ddx60 = ddx60;
    }

    public float getDdy60() {
        return ddy60;
    }

    public void setDdy60(float ddy60) {
        this.ddy60 = ddy60;
    }

    public int getDdxRed10Count() {
        return ddxRed10Count;
    }

    public void setDdxRed10Count(int ddxRed10Count) {
        this.ddxRed10Count = ddxRed10Count;
    }

    public int getDdxRed10Continue() {
        return ddxRed10Continue;
    }

    public void setDdxRed10Continue(int ddxRed10Continue) {
        this.ddxRed10Continue = ddxRed10Continue;
    }

    public int getSmallVolChaShou() {
        return smallVolChaShou;
    }

    public void setSmallVolChaShou(int smallVolChaShou) {
        this.smallVolChaShou = smallVolChaShou;
    }

    public int getZiJinQiangdu() {
        return ziJinQiangdu;
    }

    public void setZiJinQiangdu(int ziJinQiangdu) {
        this.ziJinQiangdu = ziJinQiangdu;
    }

    public int getVolIn() {
        return volIn;
    }

    public void setVolIn(int volIn) {
        this.volIn = volIn;
    }

    public int getVolOut() {
        return volOut;
    }

    public void setVolOut(int volOut) {
        this.volOut = volOut;
    }

    public int getAvgVolIn() {
        return avgVolIn;
    }

    public void setAvgVolIn(int avgVolIn) {
        this.avgVolIn = avgVolIn;
    }

    public int getAvgVolOut() {
        return avgVolOut;
    }

    public void setAvgVolOut(int avgVolOut) {
        this.avgVolOut = avgVolOut;
    }

    public int getCumulateSmall() {
        return cumulateSmall;
    }

    public void setCumulateSmall(int cumulateSmall) {
        this.cumulateSmall = cumulateSmall;
    }

    public int getCumulateNet() {
        return cumulateNet;
    }

    public void setCumulateNet(int cumulateNet) {
        this.cumulateNet = cumulateNet;
    }

    public float getInPercentXLarge() {
        return inPercentXLarge;
    }

    public void setInPercentXLarge(float inPercentXLarge) {
        this.inPercentXLarge = inPercentXLarge;
    }

    public float getOutPercentXLarge() {
        return outPercentXLarge;
    }

    public void setOutPercentXLarge(float outPercentXLarge) {
        this.outPercentXLarge = outPercentXLarge;
    }

    public float getInPercentLarge() {
        return inPercentLarge;
    }

    public void setInPercentLarge(float inPercentLarge) {
        this.inPercentLarge = inPercentLarge;
    }

    public float getOutPercentLarge() {
        return outPercentLarge;
    }

    public void setOutPercentLarge(float outPercentLarge) {
        this.outPercentLarge = outPercentLarge;
    }

    public float getInPercentMid() {
        return inPercentMid;
    }

    public void setInPercentMid(float inPercentMid) {
        this.inPercentMid = inPercentMid;
    }

    public float getOutPercentMid() {
        return outPercentMid;
    }

    public void setOutPercentMid(float outPercentMid) {
        this.outPercentMid = outPercentMid;
    }

    public float getInPercentSmall() {
        return inPercentSmall;
    }

    public void setInPercentSmall(float inPercentSmall) {
        this.inPercentSmall = inPercentSmall;
    }

    public float getOutPercentSmall() {
        return outPercentSmall;
    }

    public void setOutPercentSmall(float outPercentSmall) {
        this.outPercentSmall = outPercentSmall;
    }

    public float getLiangBi() {
        return liangBi;
    }

    public void setLiangBi(float liangBi) {
        this.liangBi = liangBi;
    }

    public float getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(float peRatio) {
        this.peRatio = peRatio;
    }

    public float getPePs() {
        return pePs;
    }

    public void setPePs(float pePs) {
        this.pePs = pePs;
    }
}
