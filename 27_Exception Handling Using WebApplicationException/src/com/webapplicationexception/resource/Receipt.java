package com.webapplicationexception.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "accountNo", "accountHolderName", "amount", "status" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "receipt")
public class Receipt {

	@XmlElement(name = "account-no")
	private String accountNo;

	@XmlElement(name = "acc-holder-name")
	private String accountHolderName;

	@XmlElement(name = "amount")
	private int amount;

	@XmlElement(name = "status")
	private String status;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
