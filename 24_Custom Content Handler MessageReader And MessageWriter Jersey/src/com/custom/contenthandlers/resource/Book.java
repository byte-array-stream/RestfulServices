package com.custom.contenthandlers.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "isbn", "bookTitle", "author", "price" })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	@XmlElement
	protected String isbn;
	@XmlElement
	protected String bookTitle;;
	@XmlElement
	protected String author;
	@XmlElement
	protected int price;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookTitle=" + bookTitle + ", author=" + author + ", price=" + price + "]";
	}
}
