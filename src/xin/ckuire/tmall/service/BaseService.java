package xin.ckuire.tmall.service;

import java.util.List;

import xin.ckuire.tmall.util.Page;

public interface BaseService {
	/**
	 * 
	* @Title: save 
	* @Description: ��������
	* @param @param object
	* @param @return    �趨�ļ� 
	* @return Integer    �������� 
	* @throws
	 */
	public Integer save(Object object);
	/**
	 * 
	* @Title: update 
	* @Description: �޸�
	* @param @param object    �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
    public void update(Object object);
    /**
     * 
    * @Title: delete 
    * @Description: ɾ��ĳ��ʵ�����
    * @param @param object    �趨�ļ� 
    * @return void    �������� 
    * @throws
     */
    public void delete(Object object);
    /**
     * 
    * @Title: get 
    * @Description: ����ʵ�����ͺ�id����ȡ����
    * @param @param clazz
    * @param @param id
    * @param @return    �趨�ļ� 
    * @return Object    �������� 
    * @throws
     */
    public Object get(Class clazz,int id);
    /**
     * 
    * @Title: get 
    * @Description: ����Id����ȡ����
    * @param @param id
    * @param @return    �趨�ļ� 
    * @return Object    �������� 
    * @throws
     */
    public Object searchById(int id);
    /**
     * 
    * @Title: searchAll 
    * @Description: ��������
    * @param @return    �趨�ļ� 
    * @return List    �������� 
    * @throws
     */
    public List searchAll();
    /**
     * 
    * @Title: searchByPage 
    * @Description: ����ҳ����
    * @param @param page
    * @param @return    �趨�ļ� 
    * @return List    �������� 
    * @throws
     */
    public List searchByPage(Page page);
    /**
     * 
    * @Title: total 
    * @Description: �õ�����
    * @param @return    �趨�ļ� 
    * @return int    �������� 
    * @throws
     */
    public int total();
	
}
