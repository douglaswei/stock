package com.douglas.stock.common.dao;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by wgz on 15/3/30.
 */
public interface DBRecordDao {

    @Insert("insert into gegu_page(code, date) values (#{code}, #{date})")
    public void insertRecord(@Param("code") String code, @Param("date") Date date);

    @Select("select * from gegu_page")
    public List<DBRecord> selectAll();

    @Select("select * from gegu_page where code=#{code} order by date desc")
    public List<DBRecord> selectByCodeOrderByDateDesc(@Param("code") String code);

    @Select("select * from gegu_page where code=#{code} and date=#{date}")
    public DBRecord selectOne(@Param("code") String code, @Param("date") Date date);

    @Select("select distinct code from gegu_page")
    public List<String> selectCodes();

    @Delete("delete from gegu_page where code=#{code} and date=#{date}")
    public void deleteOne(@Param("code") String code, @Param("date") Date date);

    @Delete("delete from gegu_page where code='' or (code=#{code} and (ma=null or ma=0 or maGradient=null))")
    public void deleteInvalidRecords(@Param("code") String code);

    @Update("update gegu_page set " +
            "ma=#{ma}, " +
            "maGradient=#{maGradient}, " +
            "ddx=#{ddx}, " +
            "ddy=#{ddy}, " +
            "ddz=#{ddz}, " +
            "net=#{net}, " +
            "diffActionXBig=#{diffActionXBig}, " +
            "diffActionBig=#{diffActionBig}, " +
            "diffActionMid=#{diffActionMid}, " +
            "diffActionSmall=#{diffActionSmall}, " +
            "strength=#{strength}, " +
            "activeRate=#{activeRate}, " +
            "takeRate=#{takeRate}, " +
            "diffActionPercentXBig=#{diffActionPercentXBig}, " +
            "diffActionPercentBig=#{diffActionPercentBig}, " +
            "diffActionPercentMid=#{diffActionPercentMid}, " +
            "diffActionPercentSmall=#{diffActionPercentSmall}, " +
            "activity=#{activity}, " +
            "volRatio=#{volRatio}, " +
            "ddx5=#{ddx5}, " +
            "ddy5=#{ddy5}, " +
            "ddx60=#{ddx60}, " +
            "ddy60=#{ddy60}, " +
            "ddxRed10Count=#{ddxRed10Count}, " +
            "ddxRed10Continue=#{ddxRed10Continue}, " +
            "smallVolChaShou=#{smallVolChaShou}, " +
            "ziJinQiangdu=#{ziJinQiangdu}, " +
            "volIn=#{volIn}, " +
            "volOut=#{volOut}, " +
            "avgVolIn=#{avgVolIn}, " +
            "avgVolOut=#{avgVolOut}, " +
            "cumulateSmall=#{cumulateSmall}, " +
            "cumulateNet=#{cumulateNet}, " +
            "inPercentXLarge=#{inPercentXLarge}, " +
            "outPercentXLarge=#{outPercentXLarge}, " +
            "inPercentLarge=#{inPercentLarge}, " +
            "outPercentLarge=#{outPercentLarge}, " +
            "inPercentMid=#{inPercentMid}, " +
            "outPercentMid=#{outPercentMid}, " +
            "inPercentSmall=#{inPercentSmall}, " +
            "outPercentSmall=#{outPercentSmall}, " +
            "liangBi=#{liangBi}, " +
            "hsl=#{hsl}, " +
            "peRatio=#{peRatio}, " +
            "pePs=#{pePs} " +
            "where code=#{code} and date=#{date}")
    public void updateShdjtRecord(
            @Param("code") String code,
            @Param("date") Date date,
            @Param("ma")float ma,
            @Param("maGradient")float maGradient,
            @Param("ddx")float ddx,
            @Param("ddy")float ddy,
            @Param("ddz")float ddz,
            @Param("net")int net,
            @Param("diffActionXBig")int diffActionXBig,
            @Param("diffActionBig")int diffActionBig,
            @Param("diffActionMid")int diffActionMid,
            @Param("diffActionSmall")int diffActionSmall,
            @Param("strength")float strength,
            @Param("activeRate")float activeRate,
            @Param("takeRate")float takeRate,
            @Param("diffActionPercentXBig")float diffActionPercentXBig,
            @Param("diffActionPercentBig")float diffActionPercentBig,
            @Param("diffActionPercentMid")float diffActionPercentMid,
            @Param("diffActionPercentSmall")float diffActionPercentSmall,
            @Param("activity")float activity,
            @Param("volRatio")float volRatio,
            @Param("ddx5")float ddx5,
            @Param("ddy5")float ddy5,
            @Param("ddx60")float ddx60,
            @Param("ddy60")float ddy60,
            @Param("ddxRed10Count")int ddxRed10Count,
            @Param("ddxRed10Continue")int ddxRed10Continue,
            @Param("smallVolChaShou")int smallVolChaShou,
            @Param("ziJinQiangdu")int ziJinQiangdu,
            @Param("volIn")int volIn,
            @Param("volOut")int volOut,
            @Param("avgVolIn")int avgVolIn,
            @Param("avgVolOut")int avgVolOut,
            @Param("cumulateSmall")int cumulateSmall,
            @Param("cumulateNet")int cumulateNet,
            @Param("inPercentXLarge")float inPercentXLarge,
            @Param("outPercentXLarge")float outPercentXLarge,
            @Param("inPercentLarge")float inPercentLarge,
            @Param("outPercentLarge")float outPercentLarge,
            @Param("inPercentMid")float inPercentMid,
            @Param("outPercentMid")float outPercentMid,
            @Param("inPercentSmall")float inPercentSmall,
            @Param("outPercentSmall")float outPercentSmall,
            @Param("hsl")float hsl,
            @Param("liangBi")float liangBi,
            @Param("peRatio")float peRatio,
            @Param("pePs")float pePs);


    @Update("update gegu_page set " +
            "ma=#{ma}, " +
            "maGradient=#{maGradient}, " +
            "hsl=#{hsl}, " +
            "ddx=#{ddx}, " +
            "bbd=#{bbd}, " +
            "liuTongShiZhi=#{liuTongShiZhi}, " +
            "jinLiuru=#{jinLiuru}, " +
            "cashStrength1=#{cashStrength1}, " +
            "cashStrength3=#{cashStrength3}, " +
            "cashStrength5=#{cashStrength5}, " +
            "cashStrength10=#{cashStrength10}, " +
            "cashRed3=#{cashRed3}, " +
            "cashRed5=#{cashRed5}, " +
            "cashRed10=#{cashRed10}, " +
            "cashRed20=#{cashRed20} " +
            "where code=#{code} and date=#{date}")
    public void updateBestgoFundRecord(
            @Param("code") String code,
            @Param("date") Date date,
            @Param("ma")float ma,
            @Param("maGradient")float maGradient,
            @Param("hsl")float hsl,
            @Param("ddx")float ddx,
            @Param("bbd")float bbd,
            @Param("liuTongShiZhi")float liuTongShiZhi,
            @Param("jinLiuru")float jinLiuru,
            @Param("cashStrength1")float cashStrength1,
            @Param("cashStrength3")float cashStrength3,
            @Param("cashStrength5")float cashStrength5,
            @Param("cashStrength10")float cashStrength10,
            @Param("cashRed3")int cashRed3,
            @Param("cashRed5")int cashRed5,
            @Param("cashRed10")int cashRed10,
            @Param("cashRed20")int cashRed20);


    @Update("update gegu_page set " +
            "ma=#{ma}, " +
            "maGradient=#{maGradient}, " +
            "hsl=#{hsl}, " +
            "ddx=#{ddx}, " +
            "bbd=#{bbd}, " +
            "liuTongShiZhi=#{liuTongShiZhi}, " +
            "hdJingLiang=#{hdJingLiang}, " +
            "hdCashStrength1=#{hdCashStrength1}, " +
            "hdCashStrength3=#{hdCashStrength3}, " +
            "hdCashStrength5=#{hdCashStrength5}, " +
            "hdCashStrength10=#{hdCashStrength10}, " +
            "hdCashRed3=#{hdCashRed3}, " +
            "hdCashRed5=#{hdCashRed5}, " +
            "hdCashRed10=#{hdCashRed10}, " +
            "hdCashRed20=#{hdCashRed20} " +
            "where code=#{code} and date=#{date}")
    public void updateBestgoHdRecord(
            @Param("code") String code,
            @Param("date") Date date,
            @Param("ma")float ma,
            @Param("maGradient")float maGradient,
            @Param("hsl")float hsl,
            @Param("ddx")float ddx,
            @Param("bbd")float bbd,
            @Param("liuTongShiZhi")float liuTongShiZhi,
            @Param("hdJingLiang")float hdJingLiang,
            @Param("hdCashStrength1")float hdCashStrength1,
            @Param("hdCashStrength3")float hdCashStrength3,
            @Param("hdCashStrength5")float hdCashStrength5,
            @Param("hdCashStrength10")float hdCashStrength10,
            @Param("hdCashRed3")int hdCashRed3,
            @Param("hdCashRed5")int hdCashRed5,
            @Param("hdCashRed10")int hdCashRed10,
            @Param("hdCashRed20")int hdCashRed20);

}
