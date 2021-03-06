package com.kh.sequencew;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
 
public class SequenceFileCreator extends Configured implements Tool {
 
	
  @Override
  public int run(String[] args) throws Exception {
 
    if (args.length != 2) {
      System.out.printf("Two parameters are required for SequenceFileCreator-<input dir> <output dir>\n");
      return -1;
    }
 
    Job job = new Job(getConf());
    job.setJarByClass(SequenceFileCreator.class);
    job.setMapperClass(TextMapper.class);
    job.setJobName("Create Sequence File, from text file");
 
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
 

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);

    job.setOutputFormatClass(SequenceFileOutputFormat.class);
    job.setInputFormatClass(TextInputFormat.class);
    
    job.setNumReduceTasks(0);
 
    boolean success = job.waitForCompletion(true);
    return success ? 0 : 1;
    
    
  }
 
  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new SequenceFileCreator(), args);
	  
    System.exit(exitCode);
  }
}

	