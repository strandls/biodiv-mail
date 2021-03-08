/**
 * 
 */
package com.strandls.mail.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.strandls.mail.ApiConstants;
import com.strandls.mail.util.TemplateUtil;

import io.swagger.annotations.Api;

/**
 * @author Abhishek Rudra
 *
 */

@Api("mail service")
@Path(ApiConstants.V1 + ApiConstants.SERIVCE)
public class MailController {

	@Inject
	private TemplateUtil t;

	@GET
	@Path(ApiConstants.PING)
	@Produces(MediaType.TEXT_PLAIN)
	public Response ping() {
		t.getTemplateAsString("observation.ftlh", null);
		return Response.status(Status.OK).entity("PONG").build();
	}

}
