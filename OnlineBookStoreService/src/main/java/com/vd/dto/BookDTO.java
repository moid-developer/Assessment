package com.vd.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class BookDTO implements Serializable {
	private Integer bid;
	private String bookName;
	private String authorName;
	private Double price;
	private String description;
	private Boolean avbStatus;
	private MultipartFile image;
	private String imgName;
	private Integer discount;
	private Integer qty;
	private Double finalAmount;
}
