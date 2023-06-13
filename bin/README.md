# StudentRegistration

API Usage

## Students

### 1) Add a student: 
POST http://localhost:8080/students

```
Sample Body
{
	"name": "Doruk",
    	"surname": "Demirci",
        "year": 4
}
```

### 2) Get a student with {id}: 
GET http://localhost:8080/students/{id} \
**If there is no student with respect to {id}, throws StudentNotFoundError.**

### 3) Get all students: GET http://localhost:8080/students

**If there is no student, throws StudentsNotFoundError.**

### 4)Update existing student: 
PUT http://localhost:8080/students/{id}
```	
Sample Body
{
	"name": "Doruk",
	"surname": "Demirci",
	"year": 3
}
```
**If there is no student with respect to {id}, throws StudentNotFoundError.**

### 5)Get lectures of a student: 
GET http://localhost:8080/students/lectures/{id} \
**If there is no student with respect to {id}, throws StudentNotFoundError.**

## Lectures

### 1) Add a student: 
POST http://localhost:8080/lectures
```
Sample Body
{
    "code": "CMPE160",
    "name": "Introduction Object Oriented Programming",
    "instructor": "InsturcutorA",
    "quota": 18,
    "studentsEnrolled": 17
}
```

### 2) Get a lecture with {id}: 
GET http://localhost:8080/lecture/{id} \
**If there is no lecture with respect to {id}, throws LectureNotFoundError.**

### 3) Get all lectures: 
GET http://localhost:8080/lectures  
**If there is no lecture, throws LecturesNotFoundError.**

### 4)Update existing lecture: 
PUT http://localhost:8080/lecture/{id}
```
Sample Body
{
    "code": "CMPE160",
    "name": "Introduction Object Oriented Programming",
    "instructor": "InsturcutorB",
    "quota": 28,
    "studentsEnrolled": 17
}
```
**If there is no lecture with respect to {id}, throws LectureNotFoundError.**

### 5)Get students enrolled the lecture: 
GET http://localhost:8080/lectures/students/{id}  
**If there is no lecture with respect to {id}, throws LectureNotFoundError.**

## Enrollment

### 1) Enroll a student: 
POST http://localhost:8080/enrollment/add
```
Sample Body
{
    	"studentId" : 1,
    	"lectureId": 1
}
```
**If student cannot be enrolled, throws StudentCannotAddLectureException.**

### 2) Drop a student: 
POST http://localhost:8080/enrollment/drop
```
Sample Body
{
	"studentId" : 1,
	"lectureId": 1
}
```
**If student cannot be dropped, throws StudentCannotDropLectureException.**
