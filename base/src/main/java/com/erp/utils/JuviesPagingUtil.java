package com.erp.utils;

public class JuviesPagingUtil {
	public static int getOffset(String pageNumber, String listCountPerPage){
		int pageNo = Integer.valueOf(pageNumber);
		int listCnt = Integer.valueOf(listCountPerPage);
		return (pageNo - 1) * listCnt;
	}
}
