package com.custom.contenthandlers.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"libraryBookId","isbn","title","author","price"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Acknowledgement {
	
	@XmlElement
	protected String libraryBookId;
	@XmlElement
	protected String isbn;
	@XmlElement
	protected String title;
	@XmlElement
	protected String author;
	@XmlElement
	protected int price;

	public String getLibraryBookId() {
		return libraryBookId;
	}

	public void setLibraryBookId(String libraryBookId) {
		this.libraryBookId = libraryBookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
