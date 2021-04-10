import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String inputstring = value.toString();
		for (String x : inputstring.split(" ")) {
			if(x.compareTo("Apple")==0 || x.compareTo("Banana")==0 || x.compareTo("Grapes")==0)
				context.write(new Text(x),new IntWritable(1));
		}
	}
}