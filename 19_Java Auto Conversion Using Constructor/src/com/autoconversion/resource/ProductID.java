package com.autoconversion.resource;

public class ProductID {
	protected String productNo;
	protected String productCode;
	
	public ProductID(String productID) {
		productNo = productID.substring(0, 2);
		productCode = productID.substring(3,7);
	}
	
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
