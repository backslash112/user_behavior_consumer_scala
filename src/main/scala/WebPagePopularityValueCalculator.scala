import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.HashPartitioner
import org.apache.spark.streaming.Duration

object WebPagePopularityValueCalculator {
	private val checkpointDir = "popularity-data-checkpoint"
	private val msgConsumerGroup = "user-behavior-topic-message-consumer-group"

	def main(args: Array[String]) {
		if(args.length < 2){
			println("Usage: WebPagePopularityValueCalculator zkserver1:2181, zkserver2:2181, zkserver3:2181 consumeMsgDataTimeInterval(secs)")
			System.exit(1)
		}

		// StreamingContext
		val Array(zkServers, processingInterval) = args
		val conf = new SparkConf().setAppName("Web Page Popularity Value Calculator")
		val ssc = new StreamingContext(conf, Seconds(processingInterval.toInt))

		// using updateStateByKey asks for enabling checkpoint
		ssc.checkpoint(checkpointDir)

		// Kafka Stream
		// returns: DStream of (Kafka message key, Kafka message value)
		val kafkaStream: DStream = KafkaUtils.createStream(ssc, zkServers, msgConsumerGroup, 
			Map("user-behavior-topic" -> 3))
		// msg data RDD
		// Dstream.map: Return a new DStream by applying a function to all elements of this DStream
		val msgDataRDD = kafkaStream.map(_._2)

		// popularity data
		
		// caculate the popularity value
		
		// sum the previous popularity value and current value
		
		// set the checkpoint interval to avoid too frequently data checkpoint which may
 		// significantly reduce operation throughput

	 	 //after calculation, we need to sort the result and only show the top 10 hot pages

	}
	
}