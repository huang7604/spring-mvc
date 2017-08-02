package com.springmvc.bean;

import java.util.ArrayList;

public class JsonInfoType {
	private ArrayList<JsonInfo> jsoninfos;
	
	public ArrayList<JsonInfo> getJsoninfos(){
		return jsoninfos;
	}
	
	public void setJsoninfos(ArrayList<JsonInfo> jsoninfos){
		this.jsoninfos=jsoninfos;
	}

}
