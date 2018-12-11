//package com.erp.utils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import juvis.suite.consts.Globals;
//
//public class SessionUtils {
//	//Controller용
//	public static boolean webCheck(HttpSession session, String methodName) {
//		return false;
//	}
//	
//	//Ajax용
//	public static boolean ajaxCheck(HttpSession session, String methodName, Map<String, Object> jsonMap) {
//		//세션 없을 경우 False
//		boolean error = false;
//		for(String temp : Globals.MENU_VALIDATION_ARRAY) {
//			if(methodName.equalsIgnoreCase(temp)) {
//				if(session.getAttribute("userName") != null) {
//					String sId = (String) session.getAttribute("userId");
//					String pId = (String) jsonMap.get("id");
//					return !sId.equalsIgnoreCase(pId);
//				}else {
//					error = true;
//				}
//			}
//		}
//		return error;
//	}
//	
//	//Session 인증
//	public static boolean sessionSet(HttpSession session, List<?> outputList) {
//		boolean result = false;
//		if(outputList.size() > 0) {
//			HashMap<String, Object> tempMap = new HashMap<String, Object>();
//			tempMap = (HashMap<String, Object>) outputList.get(0);
//			session.setAttribute("userId", tempMap.get("id"));
//			session.setAttribute("userName", tempMap.get("name"));
//			result = true;
//		}
//		return result;
//	}
//}
