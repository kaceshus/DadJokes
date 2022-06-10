package com.twilio;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.Scheduler;


public class SendSMS  {
	

	public static void main(String[] args) throws SchedulerException{
		


		//JobDetail j= JobBuilder.newJob(QuartzTest.class).build();
		//Trigger t = TriggerBuilder.newTrigger().withIdentity("Daily").startNow().build();
		//Scheduler s = StdSchedulerFactory.getDefaultScheduler();	
		//s.start();
		//s.scheduleJob(j, t);
		
		

		
		
		
		
		
		GUI.subscribe();
		
	
		
		
		
	}



}
