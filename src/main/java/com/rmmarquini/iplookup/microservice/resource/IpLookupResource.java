package com.rmmarquini.iplookup.microservice.resource;

import com.rmmarquini.iplookup.microservice.entity.UserStats;
import com.rmmarquini.iplookup.microservice.repository.UserStatsRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Rafael Marquini
 *         hello@rmmarquini.dev
 *         --
 */
@Path("/api")
@RequestScoped
public class IpLookupResource {

    @Inject
    Logger logger;

    @Inject
    UserStatsRepository repository;

    @POST
    @Path("ip")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(
            @Context HttpServletRequest request,
            @Context ServletContext context
    ) {

        logger.info(new String(new char[50]).replace("\0", "-"));
        logger.info("New request coming...");

        UserStats userStats = repository.createUserStats(request);

        logger.info("Request from: " + userStats.getIpAddress());
        logger.info("Created objectId: " + userStats.get_id());
        logger.info("Response: " + Response.Status.CREATED);
        logger.info(new String(new char[50]).replace("\0", "-"));

        return Response
                .status(Response.Status.CREATED)
                .entity(userStats)
                .build();
    }

}