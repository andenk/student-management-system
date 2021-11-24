package se.iths.rest;


import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.ok;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {


    @Inject
    TeacherService teacherService;

    @Path("")
    @POST
    public Response createTeacher(Teacher teacher) {

        if (teacher.getName()== null) {

            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" You need to enter the teacher id \"}").build());
        }

        teacherService.createTeacher(teacher);
        return ok(teacher).build();
    }


    @Path("")
    @GET
    public Response getAllTeachers(){
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        if (allTeachers.isEmpty()) {

            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity("{\" No teacher registered \"}").build());
        }

        return Response.ok(allTeachers).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id){
        Teacher foundTeacher = teacherService.findTeacherById(id);
        return Response.ok(foundTeacher).build();
    }

}
