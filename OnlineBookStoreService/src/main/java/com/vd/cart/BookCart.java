package com.vd.cart;

import java.io.Serializable;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Component;

import com.vd.model.Book;

import lombok.Getter;

@Component(value = "cart")
@Getter
public class BookCart implements Serializable {
	private List<Book> bookCart=new Stack<Book>();
	
	public String addBookToCart(Book b) {
		bookCart.add(b);
		return bookCart.contains(b)?"Book added to Cart "+b.getBookName():"Book not added to cart "+b.getBookName();
	}
	public String removeBookFromCart(Book b) {
		bookCart.remove(b);
		return bookCart.contains(b)?"Book not removed from cart "+b.getBookName():"Book removed from cart "+b.getBookName();
	}
	public Double finalAmount(Book b) {
		Double amt=0.0;
		Double finalAmount=0.0;
		if(b.getDiscount()==0.0)
			amt= b.getPrice();
		else
			amt=b.getPrice()*b.getDiscount()/100;

		finalAmount=b.getPrice()-amt*b.getQty();
		return finalAmount;
	}

}
