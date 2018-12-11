package com.erp.comm;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.erp.member.memberService;
import com.erp.menu.menuService;
import com.erp.utils.Globals;
import com.erp.utils.StringCrypto;


@Controller
public class CommController {

	@Inject ApplicationContext applicationContext;
	@Inject memberService mService;
	@Inject StringCrypto sc;
	@Inject menuService menuService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommController.class);

	@RequestMapping(value = "/{className}/{methodName}", method = RequestMethod.GET)
	public ModelAndView forwardView(HttpServletRequest req, HttpServletResponse res, @PathVariable String className,
			@PathVariable String methodName) throws Exception, IOException {
		
		ModelAndView mav = new ModelAndView();
		
		logger.info("forwardView : "+className + "/" + methodName);
		
		return mav;
	}
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView postView(HttpServletRequest req,
			ModelAndView mav) throws Exception, IOException {
		String memberChk = (String)req.getAttribute("loginId") == null ? "" : (String)req.getAttribute("loginId");
		System.out.println(memberChk);
		if(memberChk.isEmpty()) {
			logger.info("login Page");
			mav.setViewName("member/login");
		}
		else {
			logger.info("memberPage logId : "+memberChk);
			mav.setViewName("main/index");
		}
		return mav;
	}
	
//	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
//	@RequestMapping(value = "/login/{methodName}")
//	public @ResponseBody Object commonLogin(HttpServletRequest req, @PathVariable String methodName) throws Exception, IOException {
//		
//		HttpSession session = req.getSession();/*세션*/
//		Map paramMap = new HashMap();/*멤버정보 들어갈 오브젝트*/
//		paramMap.put("loginId", req.getParameter("loginId"));
//		paramMap.put("password", sc.encrypt(Globals.PASSWORD, req.getParameter("password")));
//		Object memberInfo = null;
//		
//		if(methodName.equals("loginChk")) {/*로그인 체크*/
//			memberInfo = mService.getMemberInfo(paramMap);
//			if(memberInfo != null) {
//				session.setAttribute("memberId", paramMap.get("loginId"));			/*로그인아이디 들어갈곳*/
//				session.setAttribute("memberInfo", memberInfo);			
//			}
//		}
		/*로그아웃*/ 
//		if(methodName.equals("logOut")) {
//			session.invalidate();
//		}
//		sessionChk(req);
		return memberInfo;
//	}
	
//	@RequestMapping(value = "/login/logOut")
//	public @ResponseBody boolean commonLoginOut(HttpServletRequest req) throws Exception, IOException {
//		
//		HttpSession session = req.getSession(true);/*세션*/
//		logger.info(req.getAttribute("memberId") + " logOut");
//		boolean rtData = true;
//		session.invalidate();
//		
//		return rtData;
//	}
	
//	@RequestMapping(value = "/main/index", method = RequestMethod.GET)
//	public ModelAndView mainIndex(ModelAndView mav, HttpServletRequest req, HttpSession session) throws Exception, IOException {
		
//		HttpSession session = req.getSession();/*세션*/
//		mav.setViewName("main/index");
//		
//		String mbId = (String)session.getAttribute("memberId");
//		mav.addObject("menu",menuService.selectMenuList(mbId));			/*메인메뉴*/
//		mav.addObject("subMenu",menuService.selectSubMenuList(mbId));   /*서브메뉴*/
//		return mav;
//	}

	// Page Ajax Forword
//	@RequestMapping(value = "/{className}/{methodName}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
//	public @ResponseBody ModelAndView commonReturnPage(HttpServletRequest req,
//			HttpServletResponse res, HttpSession session, @RequestBody Map<String, Object> paramMap,
//			@PathVariable String className, @PathVariable String methodName, ModelAndView mav) throws Exception {
//
//		Map<String, Object> intputDBMap = paramMap;
//		Object beanInstance = applicationContext.getBean(className);
//		Method method = getMethod(beanInstance, methodName);
//		
//		System.out.println(intputDBMap.toString());
//		mav.addObject("rtMap" , method.invoke(beanInstance, intputDBMap));
//		mav.setViewName(className+"/"+methodName);
//		System.out.println(mav.getModelMap());
//		return mav;
//	}
//	
//	@SuppressWarnings({"unchecked","rawtypes"})
//	@RequestMapping(value = "/{className}/{methodName}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
//	public @ResponseBody Map<String,Object> commonReturnPage(HttpServletRequest req,
//			HttpServletResponse res, HttpSession session, @RequestBody Map<String, Object> paramMap,
//			@PathVariable String className, @PathVariable String methodName) throws Exception {
//
//		Map<String, Object> intputDBMap = paramMap;
//		Map<String, Object> outputMap = new HashMap();
//		Object beanInstance = applicationContext.getBean(className);
//		Method method = getMethod(beanInstance, methodName);
//		
//		
//		outputMap.put("rtMap" , method.invoke(beanInstance, intputDBMap));
//		System.out.println(intputDBMap.toString());
//		System.out.println(outputMap.toString());
//		return outputMap;
//	}

//	public static Method getMethod(Object bean, String methodName) throws Exception {
//		Method[] methods = bean.getClass().getMethods();
//		for (int inx = 0; inx < methods.length; inx++) {
//			if (methods[inx].getName().equals(methodName)) {
//				return methods[inx];
//			}
//		}
//		throw new Exception("Can't find " + methodName + ".");
//	}
//	
//	public static void sessionChk(HttpServletRequest req) {
//		HttpSession session = req.getSession(true);/*세션*/
//		Enumeration se = session.getAttributeNames();
//		while (se.hasMoreElements()) {
//			String getse = se.nextElement() + "";
//			System.out.println("@@@@@@@ session : " + getse + " : " + session.getAttribute(getse));
//		}
//		
//	}
}
