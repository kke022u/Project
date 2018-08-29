package com.java.web;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TestReducer2 extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable v : value) {
			sum += v.get();
		}
		IntWritable result = new IntWritable();
		result.set(sum);
		context.write(key, result);
	}

}
