package se.iths.rest;


import se.iths.converter.Converter;
import se.iths.entity.Student;

import se.iths.exeption.CustomException;
import se.iths.exeption.MyException;
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
    public Response createItem(Student student) {

        if (student.getFirstName() == null) {

               throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" You need to enter the students firstname \"}").build());
            }

        studentService.createItem(student);
        return ok(student).build();
    }

    @Path("lastname")
    @GET
    public Response getAllWithThisLastname(@QueryParam("lastname") String lastname) {
        List<Student> foundStudentsWithThisLastname = studentService.getAllStudentsWithThisLastname(lastname);


            if (foundStudentsWithThisLastname.isEmpty()) {
                throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" No Student registered with lastname "+ lastname+"\"}" ).build());
            }

        return Response.ok(foundStudentsWithThisLastname).build();

    }

    @Path("")
    @GET
    public Response getAllStudents() throws CustomException {
        List<Student> allStudents = studentService.getAllStudents();
            if (allStudents.isEmpty()) {
                

              throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" No Student registered \"}").build());
            }

        return Response.ok(allStudents).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        String responseMessage =  "{\" No Student with ID " + id + " \"}";
        if(foundStudent == null){


            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(responseMessage).build());
        }
       return Response.ok(foundStudent).build();
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student) {

        Student idForStudent = studentService.findStudentById(student.getId());
            if (idForStudent == null) {
                throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" No Student found for update \"}").build());
            }

        studentService.updateStudent(student);

        return ok(student).build();

    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) throws MyException {
        Student idForStudent = studentService.findStudentById(id);
        String responseMessage = "{\" No Student delete at " + id + " \"}";

        if (idForStudent == null) {

            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity( "{\" No Student delete at " + id + " \"}").build());
            }

        studentService.deleteStudent(id);
        return Response.ok().build();
    }

}
