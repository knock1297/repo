package kr.AJ.valet.admin;

import org.springframework.stereotype.Service;

@Service("admin")
public class valetServiceImpl implements valetService{

	@Override
	public String adminTest() {
		return "test";
	}
}
