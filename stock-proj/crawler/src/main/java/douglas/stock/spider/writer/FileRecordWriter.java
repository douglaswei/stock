package douglas.stock.spider.writer;

import douglas.stock.spider.Record;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by wgz on 15/3/29.
 */
public class FileRecordWriter extends RecorderWriter {
    String filename;
    private static final Logger logger = LoggerFactory.getLogger(RecorderWriter.class);

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(List<Record> records) {
        if (records == null || records.size() == 0) {
            return;
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename, true));
            for (Record record : records) {
                saveOne(record, bw);
            }
        } catch (IOException e) {
            logger.error("{}", e);
            logger.error("{}", e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    logger.error("{}", e);
                    logger.error("{}", e);
                }
            }
        }
    }

    private void saveOne(Record record, BufferedWriter bw) throws IOException {
        bw.write(String.format("%s\t%s\t%s\t%s\n",
                record.getCategory(),
                record.getCode(),
                getDateFormat().format(record.getDate()),
                StringUtils.join(record.getFields().toArray(), '\t')));
    }
}
