package kr.AJ.valet.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("admin")
public class valetServiceImpl implements valetService{

	@Override
	public String adminTest() {
		return "test";
	}
	@Override
	public List<?> dashBoard(Map<String,Object> map) {
		System.out.println("여기까지");
		return null;
	}
}
