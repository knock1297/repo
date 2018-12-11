package com.erp.member;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.erp.utils.MybatisMapper;

@Service("member")
@SuppressWarnings("rawtypes")
public class memberServiceImpl implements memberService{

	@Inject
    MybatisMapper mapper;
	
	@Override
	public Object getMemberInfo( Map paramMap){
		return mapper.selectObject("member.loginChk", paramMap);
	}
	@Override
	public List<?> memberModify( Map paramMap){
		return mapper.selectList("member.memberModify", paramMap);
	}
}
