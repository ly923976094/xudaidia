package com.daidai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Mytest {
	public static void main(String args[]) throws ParseException {
//	   根据判定条件给出乘客的距离起飞时间短近程度得分
		Scanner sc = new Scanner(System.in);
/*		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//如2016-08-10 20:40  
		
		System.out.println("请输入乘客出票时间："); 
		String ticketout_time=sc.next();//出票时间
		String fromDate = simpleFormat.format( ticketout_time);
		String ticketout_time=sc.next();//出票时间
		String str1=rs.getString(ticketout_time);
		String fromDate = simpleFormat.format(str1); 
		
	    System.out.println("请输入乘客起飞时间：");
	    String flight_time=sc.next();//起飞时间
		String toDate = simpleFormat.format( flight_time);
	    String flight_time=sc.next();//起飞时间
	    String str2=rs.getString(flight_time);
	    String toDate = simpleFormat.format(str2);  
	    
	    
	   long from = simpleFormat.parse(fromDate).getTime();  
	   long to = simpleFormat.parse(toDate).getTime();  
	   int days = (int) ((to - from)/(1000 * 60 * 60 * 24));  

	    float v5=0;
	 
	if(days<1)
	  {v5=8/36;}
	  else if (days>1&&days<7)
	  {v5=7/36;}
	  else if(days>7&&days<15)
	  {v5=6/36;}
	  else if(days>15&&days<30)
	  {v5=5/36;}
	  else if(days>30&&days<60)
	  {v5=4/36;}
	  else if(days>60&&days<120)
	  {v5=3/36;}
	  else if(days>120&&days<365)
	  {v5=2/36;}
	  else if(days>365)
	  {v5=1/36;}
	  
	  System.out.println("乘客距离起飞时间距离程度短近得分为："+v5);*/
		
//根据判定条件给出票面等级得分
	 
	  System.out.println("请输入舱位等级："); 
	  String level=sc.next();//舱位等级
     char bm=level.charAt(0);
     System.out.println(bm);
	  
	  float v6=0;
	  if(bm=='P'||bm=='F'||bm=='A')
	  {
		  System.out.println(bm);
		  v6=(float)(5/15);
		  System.out.println(v6);
	  }
	 /* else if(bm=='J'||bm=='C'||bm=='D'||bm=='Z'||bm=='R')
	  {
		  v6=4/15;
	  }
	  else if(level=="G"||level=="E"||level=="Y")
	  {
		  v6=3/15;
	  }
	  else if(level=="B"||level=="M"||level=="U"||level=="H"||level=="Q"||level=="V")
	  {
		  v6=2/15;
	  }
	  else if(level=="W"||level=="S"||level=="T"||level=="L"||level=="K"||level=="N")
	  {
		  v6=1/15;
	  }*/
	  System.out.println("乘客舱位等级得分为："+v6);
}
	}
