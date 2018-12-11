package com.erp.menu;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.erp.utils.MybatisMapper;

@Service
public class menuServiceImpl implements menuService{

	@Inject
    MybatisMapper mapper;
	
	@Override
	public List<?> selectMenuList(String mbId) {
		return mapper.selectList("menuList",mbId);
	}

	@Override
	public List<?> selectSubMenuList(String mbId) {
		return mapper.selectList("subMenuList",mbId);
	}

}
