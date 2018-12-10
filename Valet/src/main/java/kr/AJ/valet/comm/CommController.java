package kr.AJ.valet.comm;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.AJ.valet.commUtil.MethodControll;

@Controller
public class CommController {

	@Autowired ApplicationContext applicationContext;
	
	private static final Logger logger = LoggerFactory.getLogger(CommController.class);

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView postView(HttpServletRequest req,
			ModelAndView mav) throws Exception, IOException {
		mav.setViewName("/test");
		return mav;
	}
	

	// Page Forword Post
	@RequestMapping(value = "/{className}/{methodName}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody ModelAndView commonReturnPage(HttpServletRequest req,
			HttpServletResponse res, HttpSession session, @RequestBody Map<String, Object> paramMap,
			@PathVariable String className, @PathVariable String methodName, ModelAndView mav) throws Exception {

		Map<String, Object> intputDBMap = paramMap;
		Object beanInstance = applicationContext.getBean(className);
		Method method = MethodControll.getMethod(beanInstance, methodName);
		
		System.out.println(intputDBMap.toString());
		mav.addObject("rtMap" , method.invoke(beanInstance, intputDBMap));
		mav.setViewName(className+"/"+methodName);
		System.out.println(mav.getModelMap());
		return mav;
	}
	
	// Page Forword Post
	@RequestMapping(value = "/{className}/{methodName}", method = RequestMethod.GET)
	public ModelAndView commonForwardView(HttpServletRequest req, HttpServletResponse res, @PathVariable String className,
			@PathVariable String methodName, ModelAndView mav) throws Exception, IOException {
		
		logger.info("forwardView : "+className + "/" + methodName);
		return mav;
	}

//	


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
