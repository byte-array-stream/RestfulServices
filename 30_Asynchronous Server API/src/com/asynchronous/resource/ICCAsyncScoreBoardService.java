package com.asynchronous.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("/icc")
public class ICCAsyncScoreBoardService {

	@GET
	@Path("/score/{matchId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void scoreCard(@PathParam("matchId") String matchnId, @Suspended final AsyncResponse asyncResponse) {

		// Anonymous Inner class. We can pass matchId to inner class by making it final but I have passed it 
		// through constructor just for reference. Inner class can not access outer class attributes unless it 
		// is final or passed to inner class.
		new Thread(matchnId) {
			String matchId = matchnId;
			ScoreBoard board = null;

			@Override
			public void run() {
				ScoreBoardService service = new ScoreBoardService();
				board = service.scoreBoard(matchId);
				asyncResponse.resume(board);
			}

		}.start();

	}
}
