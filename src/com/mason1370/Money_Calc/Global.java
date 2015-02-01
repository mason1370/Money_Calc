package com.mason1370.Money_Calc;
import org.powerbot.script.rt6.GeItem;

public interface Global {

    	static void Tele()
    	{
    		
    		int cost,GE_Price,profit,ProfitPerHour;
    		cost = downloadString("http://itemdb-rs.runescape.com/viewitem.ws?obj=" + 0001);
    		
    	}
    	
    	
    	String[] Dog = {"Item","Magic Level","XP","Runes","Staff","Cost","GE Price","Profit","Profit/Hour"};
    	Object[][] Cat = {{"Varrock Teleport","25","35","Law(1) Fire(1) Air(3)","Air",")","0","0","0"}};
    	}

