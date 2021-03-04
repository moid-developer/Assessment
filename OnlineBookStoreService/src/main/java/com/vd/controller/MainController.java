package com.vd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vd.dto.BookDTO;
import com.vd.model.Book;
import com.vd.service.BookStoreMgmtService;

@Controller
public class MainController {
	@Autowired
	private BookStoreMgmtService bookService;
	@GetMapping("/home")
	public String generateHomePage(ModelMap map) {
		
		return "home";
	}	
	@GetMapping("/allBook")
	public String getAllBooks(ModelMap map) {
		List<BookDTO> listDTO=null;
		List<Book> bookList=new ArrayList<Book>();

		listDTO=bookService.fetchAllBook();
		listDTO.forEach(dto->{
			Book model=new Book();
			BeanUtils.copyProperties(dto, model);
			bookList.add(model);
		});
		map.addAttribute("bookList",bookList);
		return "allbooks";
	}
	@GetMapping("/showallcartitem")
	public String allCartItems(ModelMap map,@ModelAttribute("book") Book bo) {
		List<Book> cart=null;
		
		cart=bookService.showCartBook();	
		map.addAttribute("books",cart);
		return "cartitems";
	}
	@GetMapping("/addtocart")
	public String addbookToCart(RedirectAttributes map,@RequestParam("bid") Integer bid) {
		String msg=null;
		
		msg=bookService.addBookToCart(bid);
		map.addFlashAttribute("msg", msg);
		
		return "redirect:showallcartitem";
	}
	@GetMapping("/bookdetail")
	public String bookDetail(Map map,@RequestParam("bid") Integer bid) {
		Book book=bookService.getBookById(bid);
		map.put("detail", book);
		return "bookdetail";
	}
	@PostMapping("/buyNow")
	public String buyBook(Map map,@ModelAttribute("book") Book bo) {
		Double amt=null;
		Book book=null;
		
		book=bookService.getBookById(bo.getBid());
		book.setQty(bo.getQty());
		amt=bookService.finalAmount(book);
		book.setFinalAmount(amt);
		map.put("book", book);
		return "buynow";
	}
	@GetMapping("/removebook")
	public String removeBookFormCart(@RequestParam("bid") Integer bid) {
		String msg=null;
		Book bo=null;

		bo=bookService.getBookById(bid);
		bookService.removeBook(bo);
		return "redirect:allBook";
	}
}

