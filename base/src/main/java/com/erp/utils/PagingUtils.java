//package com.erp.utils;
//
//import java.util.Map;
//
//import juvis.suite.consts.Globals;
//
//public class PagingUtils {
//
//    private int defaultPageSize = 15;
//    private int pageNo = 1; // 페이지 번호
//    private int totalCount; // 게시 글 전체수
//    private int recordCountPerPage = 10;
//    private int pageSize = 15;
//    private int totalRecordCount=0;
//
//    private int totalPageCount;
//    private int firstPageNoOnPageList;
//    private int lastPageNoOnPageList;
//    private int firstRecordIndex;
//    private int lastRecordIndex;
//
//    public int getPageSize() {
//        return pageSize;
//    }
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public int getPageNo() {
//        return pageNo;
//    }
//    public void setPageNo(int pageNo) {
//        this.pageNo = pageNo;
//    }
//    public int getRecordCountPerPage() {
//        return recordCountPerPage;
//    }
//    public int getTotalCount() {
//        return totalCount;
//    }
//    public void setTotalCount(int totalCount) {
//        this.totalCount = totalCount;
//    }
//    public int setFirstPage(){
//        return this.getFirstRecordIndex();
//    }
//    public int getTotalPageCount() {
//        totalPageCount = ((getTotalRecordCount()-1)/getRecordCountPerPage()) + 1;
//        return totalPageCount;
//    }
//
//    public int getFirstPageNo(){
//        return 1;
//    }
//
//    public int getLastPageNo(){
//        return getTotalPageCount();
//    }
//
//    public int getFirstPageNoOnPageList() {
//        firstPageNoOnPageList = ((getPageNo()-1)/getPageSize())*getPageSize() + 1;
//        return firstPageNoOnPageList;
//    }
//
//    public int getLastPageNoOnPageList() {
//        lastPageNoOnPageList = getFirstPageNoOnPageList() + getPageSize() - 1;
//        if(lastPageNoOnPageList > getTotalPageCount()){
//            lastPageNoOnPageList = getTotalPageCount();
//        }
//        return lastPageNoOnPageList;
//    }
//
//    public int getFirstRecordIndex() {
//        firstRecordIndex = (getPageNo() - 1) * getPageSize();
//        return firstRecordIndex;
//    }
//
//    public int getLastRecordIndex() {
//        lastRecordIndex = getPageNo() * getPageSize();
//        return lastRecordIndex;
//    }
//
//    public int getTotalRecordCount() {
//        return totalRecordCount;
//    }
//
//    public void setTotalRecordCount(int totalRecordCount) {
//        this.totalRecordCount = totalRecordCount;
//    }
//    public Map<String,Object> setPageInfo(Map<String,Object> param){
//
//        setPageNo(DataUtils.parseInt(param.get(Globals.PAGE_NO), 1));
//        setPageSize(DataUtils.parseInt(param.get(Globals.PAGE_SIZE), defaultPageSize));
//
//        param.put(Globals.PAGE_START_NUM, getFirstRecordIndex());
//        param.put(Globals.PAGE_END_NUM, getLastRecordIndex());
//
//        return param;
//    }
//    public Map<String,Object> setPageDataTable(Map<String,Object> param){
//        firstRecordIndex = DataUtils.parseInt(param.get(Globals.PAGE_START_NUM), 0);
//        pageSize = DataUtils.parseInt(param.get(Globals.PAGE_SIZE), defaultPageSize);
//
//        param.put(Globals.PAGE_START_NUM, firstRecordIndex);
//        param.put(Globals.PAGE_END_NUM, firstRecordIndex + pageSize);
//
//        return param;
//    }
//}
