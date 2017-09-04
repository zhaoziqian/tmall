package xin.ckuire.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.ckuire.tmall.dao.impl.DaoImpl;
import xin.ckuire.tmall.entity.Category;
import xin.ckuire.tmall.service.BaseService;
import xin.ckuire.tmall.util.Page;

@Service
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	private DaoImpl dao;
	
	protected Class clazz;
	
	public BaseServiceImpl() {
		try{
			throw new Exception();	
		}
		catch(Exception e){
			StackTraceElement stes[]= e.getStackTrace();
		    String serviceImpleClassName = stes[1].getClassName();
		    try {
				Class  serviceImplClazz = Class.forName(serviceImpleClassName);
				String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
				String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
				String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".entity");
				String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
				clazz=Class.forName(pojoFullName);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}	
	}
	
	@Override
    public List searchAll() {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return dao.findByCriteria(dc);
	}
	
	@Override
	public int total() {
	    String hql = "select count(*) from " + clazz.getName() ;
	    List<Long> totalCount = dao.find(hql);
	    if(totalCount.isEmpty())
	        return 0;
	    Long result= totalCount.get(0);
	    return result.intValue();
	}
	
	@Override
	public List<Object> searchByPage(Page page) {
	    DetachedCriteria dc = DetachedCriteria.forClass(clazz);
	    dc.addOrder(Order.desc("id"));
	    return dao.findByCriteria(dc,page.getStart(),page.getCount());
	}
	
	@Override
	public Integer save(Object object) {
	    return (Integer) dao.save(object);
	}
	@Override
	public void delete(Object object) {
	    dao.delete(object);
	      
	}
	@Override
	public Object get(Class clazz, int id) {
	    return dao.get(clazz, id);
	}
	@Override
	public void update(Object object) {
	    dao.update(object);
	}
	@Override
	public Object searchById(int id) {
	    return dao.get(clazz, id);
	}
	
	

}
