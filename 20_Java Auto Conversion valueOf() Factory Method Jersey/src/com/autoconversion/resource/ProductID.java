package com.autoconversion.resource;

public class ProductID {
	protected String productNo;
	protected String productCode;
	
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
	
	public static ProductID valueOf(String productId) {
		ProductID id = new ProductID();
		id.setProductNo(productId.substring(3, 7));
		id.setProductCode(productId.substring(0, 2));
		return id;
	}
}
