// MTAGarageDataMapper.java
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MTAGarageDataMapper extends Mapper<LongWritable, Text, Text, Text> {

    private Text outKey = new Text();
    private Text outValue = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        // Assuming CSV format: C/A,Unit,SCP,Line Name,Division,Date,Time,Description,Entries,Exits
        String[] parts = line.split(",");

        // Check if the line has enough parts and skip header if present
        if (parts.length == 10 && !parts[0].equals("C/A")) { // Skipping header row
            try {
                String cA = parts[0].trim();
                String date = parts[5].trim();
                long entries = Long.parseLong(parts[8].trim());
                long exits = Long.parseLong(parts[9].trim());

                // Key: Date + C/A
                outKey.set(date + "\t" + cA);
                // Value: Entries,Exits
                outValue.set(entries + "," + exits);

                context.write(outKey, outValue);
                System.out.println("Step1 executed.");
            } catch (NumberFormatException e) {
                // Log malformed records, or skip
                System.err.println("Skipping bad record: " + line);
            }
        }
    }
}
