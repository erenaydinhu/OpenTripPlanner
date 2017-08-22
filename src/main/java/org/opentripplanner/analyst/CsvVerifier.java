package org.opentripplanner.analyst;

import com.csvreader.CsvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CsvVerifier {

    private static final Logger LOG = LoggerFactory.getLogger(PointSet.class);


    public static boolean csvIsProper(CsvReader reader, int nCols) throws IOException {

        boolean csvIsProper = true;

        while (reader.readRecord()) {
            if (reader.getColumnCount() != nCols) {
                LOG.error("CSV record {} has the wrong number of fields.", reader.getCurrentRecord());
                csvIsProper = false;
                return csvIsProper;
            }
        }
        reader.close();
        return csvIsProper;
    }


}
