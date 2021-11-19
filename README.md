Create 
http://localhost:8080/student-management-system/api/v1/students
{
	"firstName": "andreas",
	"lastName": "nehl",
	"email": "e",
	"phoneNumber": "070"
}


Read 
get all
http://localhost:8080/student-management-system/api/v1/students

get all with lastname
http://localhost:8080/student-management-system/api/v1/students/lastname

Query 
lasname nehl

get by id
http://localhost:8080/student-management-system/api/v1/students/1


Update 
http://localhost:8080/student-management-system/api/v1/students/
{
	"firstName": "anna",
	"lastName": "flen",
	"id": 1,
	"email": "elo",
	"phoneNumber": "070"
}

Delete
http://localhost:8080/student-management-system/api/v1/students/3
