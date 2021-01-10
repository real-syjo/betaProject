package com.src.syj;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetAPIController {

	@Autowired
	@Qualifier("ApiExplorer")
	private ApiExplorer au;
	
	@Value("${getapi.covid19.servicekey}")
	private String serviceKey;
	
	@Value("${getapi.corvid19.baseurl}")
	private String baseUrl;
	
	@RequestMapping("/getapi/corona")
	@ResponseBody
	public Object getApiCorvid19(HttpServletRequest req, HttpServletResponse res){
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("ServiceKey", serviceKey);
		map.put("numOfRows", "10");
		map.put("pageNo", "1");
		map.put("startCreateDt", "20200310");
		map.put("endCreateDt", "20201217");
		
		System.out.println("map==>"+map);
		
		return res;
		
	}
	
}
