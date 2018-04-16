package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Category;


public interface CategoryDao {
public  boolean saveorupdate(Category cat);
public boolean delete(Category cat);
public Category get(String CatId);
public List<Category> list();
}
