
 
import java.io.File;
 
import org.apache.log4j.Logger;
 
import com.northconcepts.datapipeline.core.DataEndpoint;
import com.northconcepts.datapipeline.core.DataReader;
import com.northconcepts.datapipeline.core.DataWriter;
import com.northconcepts.datapipeline.csv.CSVReader;
import com.northconcepts.datapipeline.excel.ExcelDocument;
import com.northconcepts.datapipeline.excel.ExcelWriter;
import com.northconcepts.datapipeline.job.Job;
 
public class WriteToANewExcelFile {
 
    public static final Logger log = DataEndpoint.log;
 
    public static void WriteToANewExcelFile() {
        DataReader reader = new CSVReader(new File("locationOfCSVFile"))
                .setFieldNamesInFirstRow(true);
 
        ExcelDocument document = new ExcelDocument();
        DataWriter writer = new ExcelWriter(document).setSheetName("balance");
 
        Job.run(reader, writer);
        
        document.save(new File("locationOfExcelFile"));
    }
 
}