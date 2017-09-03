package xin.ckuire.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.ckuire.tmall.dao.impl.DaoImpl;
import xin.ckuire.tmall.entity.Category;
import xin.ckuire.tmall.service.CategoryService;
import xin.ckuire.tmall.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private DaoImpl dao;

	@Override
	public List<Category> searchAllCategory() {
		// 构建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		//设置查询的规则
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}

	@Override
	public int getCategoryTotal() {
		String hql = "select count(*) from Category";
        List<Long> totalCount = dao.find(hql);
        if(totalCount.isEmpty()){
            return 0;
        }
        Long result= totalCount.get(0);
        // 以整数的形式返回
        return result.intValue();
	}

	@Override
	public List<Category> searchCategorByPage(Page page) {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        dc.addOrder(Order.desc("id"));
        return dao.findByCriteria(dc,page.getStart(),page.getCount());
	}

	@Override
	public void addCategory(Category category) {
		dao.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		dao.delete(category);
	}

}
