package kr.AJ.valet.comm;

import java.lang.reflect.Method;
import java.util.HashMap;
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

import kr.AJ.valet.commUtil.MethodControll;

@Controller("/ajax")
public class AjaxCommController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxCommController.class);
	@Autowired ApplicationContext applicationContext;
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@RequestMapping(value = "/{className}/{methodName}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody Map<String,Object> commonReturnPage(HttpServletRequest req,
			HttpServletResponse res, HttpSession session, @RequestBody Map<String, Object> paramMap,
			@PathVariable String className, @PathVariable String methodName) throws Exception {

		Map<String, Object> intputDBMap = paramMap;
		Map<String, Object> outputMap = new HashMap();
		Object beanInstance = applicationContext.getBean(className);
		Method method = MethodControll.getMethod(beanInstance, methodName);
		outputMap.put("rtMap" , method.invoke(beanInstance, intputDBMap));
		logger.info(intputDBMap.toString());
		logger.info(outputMap.toString());
		return outputMap;
	}
}
