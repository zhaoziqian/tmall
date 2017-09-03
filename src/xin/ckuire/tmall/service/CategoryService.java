package xin.ckuire.tmall.service;

import java.util.List;

import xin.ckuire.tmall.entity.Category;
import xin.ckuire.tmall.util.Page;

public interface CategoryService {
	/**
	 * ��ѯ���еķ��༯��
	 * @return
	 */
	List<Category> searchAllCategory();
	
	/**
	 * ��ȡ���������
	 * @return
	 */
	int getCategoryTotal();
	
	/**
	 * ͨ����ҳ����ѯ���༯��
	 * @param page
	 * @return
	 */
	List<Category> searchCategorByPage(Page page);
	
	/**
	 * ����һ������
	 * @param category
	 */
	void addCategory(Category category);
	
	/**
	 * ɾ������
	 * @param category
	 */
	void deleteCategory(Category category);
	
	
	/**
	 * 
	* @Title: searchCategoryById 
	* @Description: ���ݷ���id������ָ���������
	* @param @param id
	* @param @return    �趨�ļ� 
	* @return Category    �������� 
	* @throws
	 */
	Category searchCategoryById(int id);
	
	/**
	 * 
	* @Title: updateCateGory 
	* @Description: �޸�ָ���ķ������
	* @param @param category    �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
	void updateCateGory(Category category);
}
