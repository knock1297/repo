package kr.AJ.valet.admin;

import java.util.List;
import java.util.Map;

public interface valetService {

	public String adminTest();

	public List<?> dashBoard(Map<String,Object> map);
}
