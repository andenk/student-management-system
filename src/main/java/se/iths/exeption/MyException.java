package se.iths.exeption;

import javax.ws.rs.core.Response;

public class MyException extends Throwable {
    public Response MyException(Response build) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
