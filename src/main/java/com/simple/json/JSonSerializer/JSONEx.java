/* 
 * Assignment: Some silly JSON	             *
 * Programmer: Baran Topal                   *
 * File name: JSONEx.java 	                 *
 *                                           *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  
 */

package com.simple.json.JSonSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONEx {

	public static void createJSONArray()
	{
		// some dirty instantiations
		HashMap m1 = new HashMap();
		HashMap m2 = new HashMap();
		m1.put("1", "a");
		m1.put("2", "b");
		m2.put("3", "c");
		m2.put("4", "d");

		ArrayList al = new ArrayList();
		al.add(m1);
		al.add(m2);

		JSONArray ja = new JSONArray();

		for(int i = 0; i < al.size(); i++)
		{
			HashMap m = (HashMap)al.get(i);
			Set s = m.keySet();
			Iterator it = s.iterator();
			JSONObject jo = new JSONObject();

			while(it.hasNext())
			{
				String s1 = (String)it.next();
				String val = (String)m.get(s1);
				jo.put(s1, val);
			}
			ja.add(jo);
		}		
		System.out.println(ja.toString());		
	}

	public static void parseJSONArray()
	{

		String s = "{'foo':'bar','coolness':2.0,'altitude':39000,'pilot':{'firstName':'Buzz','lastName':'Aldrin'},'mission':'apollo 11'}";
		//JSON serializer returns JSON object.
		JSONObject json = (JSONObject)JSONSerializer.toJSON(s);

		double coolness = json.getDouble("coolness");
		int altitude = json.getInt("altitude");
		JSONObject pilot = json.getJSONObject("pilot");
		String firstName = pilot.getString("firstName");
		String lastName = pilot.getString("lastName");

		System.out.println("Coolness: " + coolness);
		System.out.println("Altitude: " + altitude);
		System.out.println("Pilot: " + pilot);	
		System.out.println("First Name & Last Name: " + firstName + " " + lastName);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createJSONArray();
		System.out.println();
		parseJSONArray();
	}

}
