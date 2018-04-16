package com.niit.FashionWear.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems {
	@Id
     private String Cartitems_Id;
     private double Price;
     @ManyToOne
     @JoinColumn(name="Cart_Id")
     private Cart cart;
     @OneToOne
     @JoinColumn(name="proId")
     private Product product;
     public CartItems()
     {
    	 this.Cartitems_Id="CITEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
     }
     public Cart getCart() {
    	 return cart;
     }
     public void setCart(Cart cart) {
    	 this.cart=cart;
     }
     public Product getProduct() {
    	 return product;
     }
     public void setProduct(Product product) {
    	 this.product=product;
     }
	public String getCartitem_Id() {
		return Cartitems_Id;
	}
	public void setCartitem_Id(String cartitem_Id) {
		Cartitems_Id = cartitem_Id;
	}
	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double d) {
		Price = d;
	}
	public String getCartitems_Id() {
		return Cartitems_Id;
	}
	public void setCartitems_Id(String cartitems_Id) {
		Cartitems_Id = cartitems_Id;
	}
	public boolean isEmpty() {
		return false;
	}
	
     
}
