package com.kh.sequencew;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class TextMapper extends
   Mapper<LongWritable, Text, Text, Text> {

 @Override
 public void map(LongWritable key, Text value, Context context)
     throws IOException, InterruptedException {
  
	  String[] sentence = value.toString().split("\t");
	  
	  context.write(new Text(sentence[0]), new Text(sentence[1]));
	  
 
 }
}