package com.erp.member;

import java.util.List;
import java.util.Map;

public interface memberService {
	public Object getMemberInfo(Map paramMap);
	public List<?> memberModify(Map paramMap);
}
