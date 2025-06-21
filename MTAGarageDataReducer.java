// MTAGarageDataReducer.java
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MTAGarageDataReducer extends Reducer<Text, Text, Text, Text> {

    private Text result = new Text();

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        long totalEntries = 0;
        long totalExits = 0;

        for (Text val : values) {
            String[] parts = val.toString().split(",");
            try {
                totalEntries += Long.parseLong(parts[0]);
                totalExits += Long.parseLong(parts[1]);
                System.out.println("Step2 executed.");
            } catch (NumberFormatException e) {
                System.err.println("Skipping bad value in reducer: " + val.toString());
            }
        }

        // Output: Date \t C/A \t TotalEntries \t TotalExits
        String[] keyParts = key.toString().split("\t");
        String date = keyParts[0];
        String cA = keyParts[1];

        result.set(date + "\t" + cA + "\t" + totalEntries + "\t" + totalExits);
        context.write(null, result); // No specific key for final output
    }
}
