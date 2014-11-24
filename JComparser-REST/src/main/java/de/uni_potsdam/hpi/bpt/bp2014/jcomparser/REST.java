package de.uni_potsdam.hpi.bpt.bp2014.jcomparser;

/**
 * Created by Jani on 24.11.2014.
 */
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("orders")
public class REST {
    // Stores state simply in a static collection class.
    private static Map<String, String> orders = new TreeMap<String, String>();

    @Path("/{order}")
    @PUT
    @Produces("text/html")
    public String create(@PathParam("order") String order,
                         @QueryParam("customer_name") String customerName)
    {
        orders.put(order, customerName);
        return "Added order #" + order;
    }

    @Path("/{order}")
    @GET
    @Produces("text/html")
    public String find(@PathParam("order") String order)
    {
        if (orders.containsKey(order))
            return "<h2>Details on Order #" + order +
                    "</h2>Customer name: " + orders.get(order);

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @Path("/list")
    @GET
    @Produces("text/html")
    public String list()
    {
        String header = " <h2>All Orders</h2>n";

        header += "<ul>";
        for (Map.Entry<String, String> order : orders.entrySet())
            header += "\n <li>#" + order.getKey() + " for " + order.getValue() + "</li>";

        header += "\n</ul>";

        return header;
    }
}
