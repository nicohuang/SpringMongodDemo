package com.flinkinfo.demo.controller;

import com.alibaba.fastjson.JSON;
import com.flinkinfo.demo.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestController
{

	@Autowired
	MongoTemplate mongoTemplate;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value="test",method=RequestMethod.GET)
	public String test(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setNickname("nico");
		userInfo1.setUsername("nicoHuang");
		userInfo1.setSex("20");
		userInfo1.setAge("33");

		String name = "userInfo"+ format.format(new Date());


		List<UserInfo> userInfoList =mongoTemplate.findAll(UserInfo.class,name);


		for (UserInfo userInfo : userInfoList)
		{
			System.out.println(JSON.toJSONString(userInfo));
		}
		return "test";
	}

}
