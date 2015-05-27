import com.douglas.stock.common.dao.DBRecord;
import com.douglas.stock.common.dao.DBRecordService;
import com.douglas.stock.dataprepare.common.Calculation;
import com.douglas.stock.dataprepare.common.RecordsTrainPredict;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wgz on 15/4/4.
 */
public class TestFuquan {

    public static List<DBRecord> getByCodeOrderByDateDesc(String code) {
        List<DBRecord> res = new ArrayList<>();

        DBRecord record = null;

        record = new DBRecord();
        record.setMa((float)5.44);
        record.setMaGradient((float) 10.0);
        record.setDate(new Date(2014, 1, 1));
        res.add(record);

        record = new DBRecord();
        record.setMa((float)4.95);
        record.setMaGradient((float) 0.0);
        record.setDate(new Date(2014, 1, 2));
        res.add(record);

        record = new DBRecord();
        record.setMa((float)9.9);
        record.setMaGradient((float) -10.0);
        record.setDate(new Date(2014, 1, 3));
        res.add(record);

        record = new DBRecord();
        record.setMa((float)11.0);
        record.setMaGradient((float) 10);
        record.setDate(new Date(2014, 1, 4));
        res.add(record);

        record = new DBRecord();
        record.setMa((float)10.0);
        record.setMaGradient((float) 10);
        record.setDate(new Date(2014, 1, 5));
        res.add(record);

        return res;
    }

    public static void main(String[] args) {
        float x = (float) 12.434353;
        float res = Float.valueOf(String.format("%.2f", x));
        RecordsTrainPredict records = new RecordsTrainPredict(getByCodeOrderByDateDesc(""));
        records.setTrain(false);
        records.setTrainBeg(0);
        records.setTrainEnd(records.getRecords().size());
        Calculation.wFuQuan(records);
        Calculation.wMACD(records);
        return;
    }
}
