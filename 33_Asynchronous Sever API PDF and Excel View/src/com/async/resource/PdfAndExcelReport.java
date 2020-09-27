package com.async.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;

@Path("/view")
public class PdfAndExcelReport {
	
	@GET
	//@Produces(MediaType.)
	@Path("/both")
	public void getPdfAndExcelReport(@Suspended AsyncResponse asyncResponse) throws IOException, InterruptedException {
		System.out.println("PdfAndExcel() called");
		
		new Thread() {
			Response response = null;
		// PDF view
			@Override
			public void run() {
				System.out.println("Inside run method");
			
				Document document = new Document();
				document.open();
				
				Phrase phrase = new Phrase();
				phrase.add("Pdf report");
				
				try {
					Table table = new Table(2);
					table.addCell("Product ID");
					table.addCell("Name");
					document.add(phrase);
				
					table.addCell("PRD7182");
					table.addCell("TV");
					document.add(table);
					document.close();
					
					response = Response.ok().header("Content-Type", "application/pdf")
											.header("Content-Disposition", "attachment; filename=products_pdf.pdf")
											.build();
					asyncResponse.resume(response);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				
			}
		}.start();
		
		/*Thread.sleep(100);
		
		new Thread() {
			
			@Override
			public void run() {
				Response response = null;
				HSSFWorkbook workBook = null;
				System.out.println("Workbook created");
				workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet();
				HSSFRow row =sheet.createRow(1);
				row.createCell(1).setCellValue("Product ID");
				row.createCell(2).setCellValue("Product Name");
				
				HSSFRow row2 = sheet.createRow(2);
				row2.createCell(1).setCellValue("PRD673");
				row2.createCell(2).setCellValue("TV");
				try {
					workBook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				response = Response.ok().header("Content-Type","application/vnd.ms-excel")
						.header("Content-disposition", "attachment; filename=products_excel.xls")
						.build();
				asyncResponse.resume(response);
			}
		}.start();
		*/
		
		
	}
}
