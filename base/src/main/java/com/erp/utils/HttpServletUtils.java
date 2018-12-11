//package com.erp.utils;
//
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import juvis.suite.consts.Globals;
//
//public class HttpServletUtils {
//
//    public static Map<String,Object> getParameterMap(HttpServletRequest request){
//
//        Map<String, Object> param = new HashMap<String, Object>();
//        //@SuppressWarnings("unchecked")
//        Enumeration<String> enumeration = request.getParameterNames();
//
//        while (enumeration.hasMoreElements()) {
//            String key = enumeration.nextElement();
//            param.put(key, DataUtils.xssFilter(String.valueOf(request.getParameter(key))));
//        }
//        HttpSession session = request.getSession();
//        if(session.getAttribute("SESSION_ID")!=null){ //세션값이 있을경우 세션값 셋팅
//            param.put("SESSION_ID", session.getAttribute("SESSION_ID"));
//            param.put("SESSION_PWD", session.getAttribute("SESSION_PWD"));
//            param.put("SESSION_NAME", session.getAttribute("SESSION_NAME"));
//            param.put("SESSION_DEPT_CD", session.getAttribute("SESSION_DEPT_CD"));
//            param.put("SESSION_OFFI", session.getAttribute("SESSION_OFFI"));
//            param.put("SESSION_OFFI_NM", session.getAttribute("SESSION_OFFI_NM"));
//            param.put("SESSION_HQ_OFFI", session.getAttribute("SESSION_HQ_OFFI"));
//            param.put("SESSION_HQ_OFFI_NM", session.getAttribute("SESSION_HQ_OFFI_NM"));
//            param.put("SESSION_LOGIN_IP", session.getAttribute("SESSION_LOGIN_IP"));
//            param.put("SESSION_USR_TY", session.getAttribute("SESSION_USR_TY"));
//        }
//        if(param.get(Globals.PAGE_START_NUM)!=null){
//            param = new PagingUtils().setPageDataTable(param);
//            param.put("draw", param.get("draw"));
//        }
//        return param;
//    }
//
//}
