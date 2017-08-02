package com.springmvc.dao;

import java.util.ArrayList;


import org.springframework.stereotype.Repository;

import com.springmvc.bean.JsonInfo;

@Repository
public interface JsonInfoDao {
	void insertJsonInfo(JsonInfo jsoninfo);
	ArrayList<JsonInfo> selectJsonInfos();

}
