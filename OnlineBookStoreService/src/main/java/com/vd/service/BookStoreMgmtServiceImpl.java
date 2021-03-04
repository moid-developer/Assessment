package com.vd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.BookBO;
import com.vd.cart.BookCart;
import com.vd.dto.BookDTO;
import com.vd.model.Book;
import com.vd.repository.BookStoreRepository;

@Service("bookService")
public class BookStoreMgmtServiceImpl implements BookStoreMgmtService {
	@Autowired
	private BookStoreRepository bookRepo;
	@Autowired
	private BookCart cart;
	
	
	@Override
	public List<BookDTO> fetchAllBook() {
		List<BookDTO> listDTO=new ArrayList<BookDTO>();
		Iterable<BookBO> listBO=null;
		
		listBO=bookRepo.findAll();
		
		listBO.forEach(bo->{
		BookDTO dto=new BookDTO();
		BeanUtils.copyProperties(bo, dto);
		listDTO.add(dto);
		});
		return listDTO;
	}
	@Override
	public String addBookToCart(Integer id) {
		Optional<BookBO> bo=null;
		Book model=null;
		String msg=null;
		
		model=new Book();
		bo=bookRepo.findById(id);
		BeanUtils.copyProperties(bo.get(), model);
		msg=cart.addBookToCart(model);
		return msg;
	}
	@Override
	public List showCartBook() {
		return cart.getBookCart();
	}
	@Override
	public Book getBookById(Integer id) {
		Book book=null;
		Optional<BookBO> opt=null;
		
		opt=bookRepo.findById(id);
		book=new Book();
		BeanUtils.copyProperties(opt.get(), book);
		return book;
	}
	@Override
	public Double finalAmount(Book book) {
		Double amt=cart.finalAmount(book);
		cart.removeBookFromCart(book);
		return amt;
	}
	@Override
	public void removeBook(Book b) {
		cart.removeBookFromCart(b);
	}
}
