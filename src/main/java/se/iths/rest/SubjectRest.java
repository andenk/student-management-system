package se.iths.rest;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.Response.ok;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {


    @Inject
    SubjectService subjectService;


    @Path("")
    @POST
    public Response createSubject(Subject subject) {

        if (subject.getCourseName()== null) {

            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" You need to enter the students firstname \"}").build());
        }

        subjectService.createSubject(subject);
        return ok(subject).build();
    }


    @Path("")
    @GET
    public Response getAllSubjects(){
        List<Subject> allSubjects = subjectService.getAllSubjects();
        if (allSubjects.isEmpty()) {

            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" No Subject registered \"}").build());
        }

        return Response.ok(allSubjects).build();
    }

}
