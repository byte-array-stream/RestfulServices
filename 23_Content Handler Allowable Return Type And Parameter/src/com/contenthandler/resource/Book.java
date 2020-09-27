package com.contenthandler.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(name = "book", propOrder = { "isbn", "bookTitle", "price", "author" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	@XmlElement(name = "isbn")
	protected String isbn;

	@XmlElement(name = "book-title")
	protected String bookTitle;

	@XmlElement(name = "price")
	protected int price;

	@XmlElement(name = "author")
	protected String author;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
