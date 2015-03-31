package douglas.stock.spider.Seed;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wgz on 15/3/30.
 */
public class SeedTemplate implements SeedInterface {
    private String templateSeed;
    private Date date;
    private int backwardSpan;
    private DateFormat dateFormat;

    public SeedTemplate() {
    }

    public String getTemplateSeed() {
        return templateSeed;
    }

    public void setTemplateSeed(String templateSeed) {
        this.templateSeed = templateSeed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBackwardSpan() {
        return backwardSpan;
    }

    public void setBackwardSpan(int backwardSpan) {
        this.backwardSpan = backwardSpan;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public List<String> getSeeds() {
        List<String> seeds = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        for (int idx = 0; idx < backwardSpan; ++idx) {
            calendar.add(Calendar.DATE, -1);
            Date ndate = calendar.getTime();
            String seed = templateSeed.replace("${date}", dateFormat.format(ndate));
            seeds.add(seed);
        }
        return seeds;
    }

}
