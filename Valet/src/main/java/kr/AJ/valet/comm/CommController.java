package kr.AJ.valet.comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommController {

	@RequestMapping("/")
	public @ResponseBody String homeTest() {
		return "Spring Boot Test Mode";
	}
	
}
