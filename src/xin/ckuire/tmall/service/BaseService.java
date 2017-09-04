package xin.ckuire.tmall.service;

import java.util.List;

import xin.ckuire.tmall.util.Page;

public interface BaseService {
	/**
	 * 
	* @Title: save 
	* @Description: 保存内容
	* @param @param object
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer save(Object object);
	/**
	 * 
	* @Title: update 
	* @Description: 修改
	* @param @param object    设定文件 
	* @return void    返回类型 
	* @throws
	 */
    public void update(Object object);
    /**
     * 
    * @Title: delete 
    * @Description: 删除某个实体对象
    * @param @param object    设定文件 
    * @return void    返回类型 
    * @throws
     */
    public void delete(Object object);
    /**
     * 
    * @Title: get 
    * @Description: 根据实体类型和id来获取对象
    * @param @param clazz
    * @param @param id
    * @param @return    设定文件 
    * @return Object    返回类型 
    * @throws
     */
    public Object get(Class clazz,int id);
    /**
     * 
    * @Title: get 
    * @Description: 根据Id来获取对象
    * @param @param id
    * @param @return    设定文件 
    * @return Object    返回类型 
    * @throws
     */
    public Object searchById(int id);
    /**
     * 
    * @Title: searchAll 
    * @Description: 查找所有
    * @param @return    设定文件 
    * @return List    返回类型 
    * @throws
     */
    public List searchAll();
    /**
     * 
    * @Title: searchByPage 
    * @Description: 按分页查找
    * @param @param page
    * @param @return    设定文件 
    * @return List    返回类型 
    * @throws
     */
    public List searchByPage(Page page);
    /**
     * 
    * @Title: total 
    * @Description: 得到总数
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    public int total();
	
}
