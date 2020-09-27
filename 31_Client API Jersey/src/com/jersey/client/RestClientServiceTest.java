package com.jersey.client;

public class RestClientServiceTest {

	public static void main(String[] args) {
		RestClientService clientService = new RestClientService();
		/*Book book = clientService.getBookInfo("ISBN758925");
		System.out.println(book.getIsbn()+" :: " +book.getBookTitle());*/
		
		
		Book preface = new Book();
		preface.setIsbn("ISBN3877");
		preface.setAuthor("ravi");
		preface.setBookTitle("Java");
		preface.setPrice(817);
		System.out.println(clientService.addPreface(preface));
	}

}
