package com.erp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("mybatisMapper")
public class MybatisMapper extends SqlSessionDaoSupport {
	private static final long serialVersionUID = -1375151959664915520L;

	public List<HashMap<String, Object>> selectTestTable() {

		// TODO Auto-generated method stub

		List<HashMap<String, Object>> testTableList = new ArrayList<HashMap<String, Object>>();

		testTableList = getSqlSession().selectList("test");

		return testTableList;

	}

	public int insert(String queryId) {
		return getSqlSession().insert(queryId);
	}

	public int insert(String queryId, Map<String, Object> map) {
		return getSqlSession().insert(queryId, map);
	}

	public int update(String queryId, Map<String, Object> map) {
		return getSqlSession().update(queryId, map);
	}

	public int update(String queryId) {
		return getSqlSession().update(queryId);
	}

	public int delete(String queryId, Map<String, Object> map) {
		return getSqlSession().delete(queryId, map);
	}

	public int delete(String queryId) {
		return getSqlSession().delete(queryId);
	}

	public String selectOne(String queryId) {
		return getSqlSession().selectOne(queryId);
	}

	public String selectOne(String queryId, Map<String, Object> map) {
		return getSqlSession().selectOne(queryId, map);
	}

	public int selectOneInt(String queryId, Map<String, Object> map) {
		return getSqlSession().selectOne(queryId, map);
	}

	public Map<String, Object> select(String queryId, String map) {
		return getSqlSession().selectMap(queryId, map);
	}

	public Object selectObject(String queryId, Object object) {
		return getSqlSession().selectOne(queryId, object);
	}

	public List<Map<String, Object>> selectList(String queryId) {
		return getSqlSession().selectList(queryId);
	}

	public List<?> selectList(String queryId, Map<String, Object> map) {
		return getSqlSession().selectList(queryId, map);
	}
	public List<?> selectList(String queryId, String str) {
		return getSqlSession().selectList(queryId, str);
	}
}
