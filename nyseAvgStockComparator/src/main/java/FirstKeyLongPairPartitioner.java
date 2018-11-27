import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FirstKeyLongPairPartitioner extends Partitioner<CustomLongPair, Text> {

	@Override
	public int getPartition(CustomLongPair key, Text value, int numPartitions) {
		
		long partValue = key.getFirst().get();
		return (int) (partValue%numPartitions);
	}

	
}
