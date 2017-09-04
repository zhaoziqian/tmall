package xin.ckuire.tmall.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;


import xin.ckuire.tmall.entity.Category;
import xin.ckuire.tmall.service.CategoryService;
import xin.ckuire.tmall.util.ImageUtil;
import xin.ckuire.tmall.util.Page;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	@Result(name="listCategory",location="/admin/listCategory.jsp"),
	@Result(name="listCategoryPage", type = "redirect", location="/admin_category_list"),
	@Result(name="editCategory", location="/admin/editCategory.jsp")
})
public class CategoryAction {
	
	@Autowired
	private CategoryService categoryService;
	private Category category;
	private List<Category> categories;
	private Page page;
	private File img;
	
	
	@Action("admin_category_list")
	public String categoryList(){
		if(page == null){
			page = new Page();
		}
		// 查询总数
		int total = categoryService.total();
		page.setTotal(total);
		
		categories = categoryService.searchByPage(page);
		System.out.println(categories);
		return "listCategory";
	}
	
	@Action("admin_category_add")
	public String add() {
	    categoryService.save(category);
	    System.out.println(ServletActionContext.getServletContext().getRealPath("img/category"));
	    File imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
	    File file = new File(imageFolder,category.getId()+".jpg");
	    try {
	        FileUtils.copyFile(img, file);
	        BufferedImage img = ImageUtil.change2jpg(file);
	        ImageIO.write(img, "jpg", file);            
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "listCategoryPage";
	}   
	
	
	@Action("admin_category_delete")
	public String delete() {
	    categoryService.delete(category);
	    return "listCategoryPage";
	}  
	
	@Action("admin_category_edit")
    public String edit() {
        int id = category.getId();
        category = (Category) categoryService.searchById(id);
        return "editCategory";
    }   
	
	
	@Action("admin_category_update")
	    public String update() {
	        categoryService.update(category);
	        // 如果有修改图片，则..修改图片在图片仓库中
	        if(null!=img){
	            File imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
	            File file = new File(imageFolder,category.getId()+".jpg");
	            try {
	                FileUtils.copyFile(img, file);
	                BufferedImage img = ImageUtil.change2jpg(file);
	                ImageIO.write(img, "jpg", file);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }           
	        }
	        return "listCategoryPage";
	    }   
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	
	
}


