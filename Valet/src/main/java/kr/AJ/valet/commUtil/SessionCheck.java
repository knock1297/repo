package kr.AJ.valet.commUtil;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class SessionCheck {

	private static final Logger logger = LoggerFactory.getLogger(SessionCheck.class);
	
	public static void sessionChk(HttpSession session) {
		
		Enumeration sessionName = session.getAttributeNames();
		while (sessionName.hasMoreElements()) {
			String getSession = sessionName.nextElement() + "";
			logger.info("session : " + sessionName + " : " + session.getAttribute(getSession));
		}
		
	}
}
