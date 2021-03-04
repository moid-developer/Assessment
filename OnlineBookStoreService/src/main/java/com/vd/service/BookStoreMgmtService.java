package com.vd.service;

import java.util.List;

import com.vd.dto.BookDTO;
import com.vd.model.Book;

public interface BookStoreMgmtService {
	public List<BookDTO> fetchAllBook();
	public String addBookToCart(Integer id);
	public List showCartBook();
	public Book getBookById(Integer id);
	public Double finalAmount(Book book);
	public void removeBook(Book b);
	
}
