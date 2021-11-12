package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static javax.ws.rs.core.Response.*;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createItem(Student student){
        studentService.createItem(student);
        return ok(student).build();
    }

    @Path("")
    @GET
    public Response getAllItem(){
        List<Student> foundItems= studentService.getAllStudents();
        return Response.ok(foundItems).build();
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student){
        studentService.updateStudent(student);
        return ok(student).build();

    }
    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

}
