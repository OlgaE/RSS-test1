package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class RssReader {
	
	public static void main(String[] args) {
		
		try {
			System.out.println(readRSS("http://rss.cnn.com/rss/edition.rss"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String readRSS(String url) throws IOException, MalformedURLException {
		
		URL rssURL = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(rssURL.openStream()));
		String sourseCode = null;
		
		String line;
		while((line = in.readLine()) != null){
			
			if(line.contains("<title>")){
				int firstPos = line.indexOf("<title>");
				String temp = line.substring(firstPos);
				temp = temp.replace("<title>","");
				
				int lastPos = temp.indexOf("</title>");
				temp = temp.substring(0,lastPos);
				
				sourseCode += temp + "\n";
			}
			
		}
		
		in.close();
		return sourseCode;
	}

}
