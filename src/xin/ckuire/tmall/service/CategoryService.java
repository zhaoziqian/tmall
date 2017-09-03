package xin.ckuire.tmall.service;

import java.util.List;

import xin.ckuire.tmall.entity.Category;
import xin.ckuire.tmall.util.Page;

public interface CategoryService {
	/**
	 * 查询所有的分类集合
	 * @return
	 */
	List<Category> searchAllCategory();
	
	/**
	 * 获取分类的总数
	 * @return
	 */
	int getCategoryTotal();
	
	/**
	 * 通过分页来查询分类集合
	 * @param page
	 * @return
	 */
	List<Category> searchCategorByPage(Page page);
	
	/**
	 * 增加一个分类
	 * @param category
	 */
	void addCategory(Category category);
	
	/**
	 * 删除分类
	 * @param category
	 */
	void deleteCategory(Category category);
}
