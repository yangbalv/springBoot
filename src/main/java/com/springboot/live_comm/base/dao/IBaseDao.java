/**
 * IBaseDao.java
 *
 * Copyright 2010 Shanghai Everelegance Technologies Co.,Ltd. All rights reserved. 
 * 
 */
package com.springboot.live_comm.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

/**
 * @author Everelegance ESBuilder Workgroup> josh
 * 
 * @created 2013-3-22 上午11:55:53
 * 
 * @version 1.0
 *
 * @comment 通用的Dao接口类
 *
 * @modify
 * 
 */
public interface IBaseDao<M extends Serializable, PK extends Serializable> {
	
	
	/**
	 * 添加实体
	 * @param t
	 * @return
	 */
	public int insert(M t) throws DataAccessException;
	
	/**
	 * 批量添加实体
	 * @param list
	 * @return
	 */
	public int batchInsert(List<? extends M> list) throws DataAccessException;
	
	
	/**
	 * 修改实体
	 * @param t
	 * @return
	 */
	public int update(M t) throws DataAccessException;
	
	
	/**
	 * 批量修改实体
	 * @param t
	 * @return
	 */
	public int batchUpdate(M t) throws DataAccessException;
	
	
	
	
	/**
	 * 根据条件删除实体
	 * @param id
	 */
	public int delete(M m) throws DataAccessException;
	
	/**
	 * 根据条件删除实体
	 * @param id
	 */
	public int delete(Map<String,Object> param) throws DataAccessException;
	
	/**
	 * 删除全部实体
	 * @param id
	 */
	public int deleteAll() throws DataAccessException;
	
	/**
	 * 删除指定Key的实体
	 * @param id
	 */
	public int deleteById(PK id) throws DataAccessException;
	
	

	/**
	 * 根据传入的实体数组，批量删除
	 * @param pks
	 * @return
	 * @throws DataAccessException
	 */
	public int batchDelete(PK pks[])  throws DataAccessException;
	

	
	
	
	/**
	 * 
	 * 根据Key查询单个实体
	 *
	 * @param rowBounds
	 * @param queryParams
	 * @return
	 */
	public M selectById(PK id) throws DataAccessException;
	
	
	
	/**
	 * 
	 * 根据输入条件查询单个实体
	 *
	 * @param rowBounds
	 * @param queryParams
	 * @return
	 */
	public M selectOne(M m) throws DataAccessException;
	
	/**
	 * 
	 * 根据输入条件查询单个实体
	 *
	 * @param rowBounds
	 * @param queryParams
	 * @return
	 */
	public M selectOne(Map<String, Object> queryParams) throws DataAccessException;
	
	

	/**
	 * 
	 * 查询所有列表
	 *
	 * @param rowBounds
	 * @param queryParams
	 * @return
	 */
	public List<M> selectAll() throws DataAccessException;
	
	
	public List<M> selectList(M m) throws DataAccessException;
	
	
	public List<M> selectList(Map<String, Object> queryParams) throws DataAccessException;
	
	
	public List<M> selectPageList(M m,int start,int limit) throws DataAccessException;
	
	public List<M> selectPageList(Map<String, Object> queryParams,int start,int limit) throws DataAccessException;
	
	
	/**
	 * 
	 * 根据输入条件查询数量。
	 *
	 * @param queryParams
	 * @return
	 * @throws DataAccessException
	 */
	public Integer selectCount(Map<String, Object> queryParams) throws DataAccessException;
	
	/**
	 * 
	 * 根据输入条件查询数量。
	 *
	 * @param queryParams
	 * @return
	 * @throws DataAccessException
	 */
	public Integer selectCount(M m) throws DataAccessException;

}
