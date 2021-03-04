package com.vd.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BookInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BOOKID")
	private int bid;
	@Column(name="BOOKNAME",length=200)
	private String bookName;
	@Column(name="AUTHORNAME",length=50)
	private String authorName;
	@Column(name="PRICE",length=20)
	private Double price;
	@Column(name="DESCRIPTION",length=5000)
	private String description;
	@Column(name="STATUS")
	@Type(type = "boolean")
	private boolean avbStatus;
	@Column(name="IMAGENAME")
	private String imgName;
	@Column(name="DISCOUNT")
	private Integer discount;
	
}
