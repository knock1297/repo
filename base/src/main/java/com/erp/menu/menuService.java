package com.erp.menu;

import java.util.List;

public interface menuService {

	List<?> selectMenuList(String mbId); 	/*메인메뉴*/
	List<?> selectSubMenuList(String mbId); /*서브메뉴*/
}
