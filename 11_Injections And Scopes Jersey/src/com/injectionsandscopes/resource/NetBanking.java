package com.injectionsandscopes.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * First constructor injection will be performed, then attribute injection will be performed. Later Method level 
 * injection will be performed. Observe the output. IFSC code will be Null because I am printing it in constructor level 
 * at this level ifsc code will not be initialized. After constructor it will gets initialized. But account no will
 * have its values.
 */

/*For attribute level
@Path("/banking/{account-no}")*/

@Path("/banking/{accountNo}/{ifscCode}")
public class NetBanking {

	/*
	 * Attribute level. We should go for attribute level when we a common attribute
	 * for all the methods.
	 * 
	 * @PathParam("account-no") protected String accountNo;
	 */

	protected String accountNo;

	// Attribute level
	@PathParam("ifscCode")
	protected String ifscCode;

	// Constructor level. We should go for constructor level when we have some
	// common pre processing logic.
	public NetBanking(@PathParam("accountNo") String accountNo) {
		this.accountNo = accountNo;

		System.out.println(accountNo);
		System.out.println("Ifsc Code ::" + ifscCode);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/balance")
	public float getBalance() {
		return 27489.89f;
	}

	@GET
	@Path("/payees")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPayees() {
		return "Payee is :: ravi for the account no ::" + accountNo;
	}
}
