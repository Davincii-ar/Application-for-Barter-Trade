package com.jva.web.resources;

import com.jva.entity.Item;
import com.jva.service.ItemService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
    
@Path("/items")
@Stateless
public class ItemsService {

    @EJB
    private ItemService itemservice;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getTrips() {
        return itemservice.ListItems();
    }
    
    /*@GET @Path("/{departure}")
    public List<Trip> getMyTrips(@PathParam("query") Long departure) {
        return tripService.findTripByDepartureArrivalPrice(departure, departure, null);
    }*/
}
