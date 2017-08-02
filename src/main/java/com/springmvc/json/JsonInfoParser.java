package com.springmvc.json;



import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.bean.JsonInfo;
import com.springmvc.bean.JsonInfoType;



@Component
public class JsonInfoParser {
	
	@Value("${json.path}")
	private String path;
	
	public void writeJsonInfo(JsonInfoType type) throws Exception{		
		new ObjectMapper().writeValue(new File(path),type);
	}
	
	public ArrayList<JsonInfo> readJsonInfo()throws Exception{
		JsonInfoType type=null;
		
			type=new ObjectMapper().readValue(new File(path), JsonInfoType.class);
		
		return type.getJsoninfos();
	}

}
