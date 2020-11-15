--Creating Students TABLE 
CREATE TABLE Students 
    (student_id VARCHAR2(6)
        CONSTRAINT student_id_pk PRIMARY KEY,
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    date_of_birth DATE,
    email VARCHAR2(30) 
        CONSTRAINT email_unique UNIQUE);
            
--Creating Teachers TABLE
CREATE TABLE Teachers
    (employee_id VARCHAR2(6)
        CONSTRAINT employee_id_pk PRIMARY KEY,
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    hire_date DATE,
    email VARCHAR2(30) 
        CONSTRAINT email_cons_unique UNIQUE);
        
        
--Creating Courses TABLE 
CREATE TABLE Courses 
    (course_id VARCHAR2(6)
        CONSTRAINT course_id_pk PRIMARY KEY,
     course_name VARCHAR2(20),
     start_date DATE,
     class_room NUMBER (3));
     
     
--Creating Registration TABLE
CREATE TABLE Registration 
    (course_id VARCHAR2(6)
         CONSTRAINT course_id_fk
            REFERENCES Courses(course_id),
     course_name VARCHAR2(20),
     schedule VARCHAR2(5) CHECK (schedule ='DAY' OR schedule ='NIGHT'),
     student_id VARCHAR2(6)
         CONSTRAINT student_id_fk
            REFERENCES Students(student_id),
     employee_id VARCHAR2(6)
         CONSTRAINT employee_id_fk
            REFERENCES Teachers(employee_id));

     
     
--Creating PROCEDURE to INSERT a Student 
CREATE PROCEDURE insert_student 
    (insert_student_id IN students.student_id%TYPE,
     insert_first_name IN students.first_name%TYPE,
     insert_last_name IN students.last_name%TYPE,
     insert_date_of_birth IN students.date_of_birth%TYPE,
     insert_email IN students.email%TYPE)
    IS
    BEGIN
    INSERT INTO Students 
    (student_id,first_name,last_name,date_of_birth,email)
    VALUES 
    (insert_student_id,insert_first_name,insert_last_name,insert_date_of_birth,insert_email);
    END insert_student;
  
    
--Creating PROCEDURE to INSERT a Teacher 
CREATE PROCEDURE insert_teacher
    (insert_employee_id IN teachers.employee_id%TYPE,
     insert_first_name IN teachers.first_name%TYPE,
     insert_last_name IN teachers.last_name%TYPE,
     insert_hire_date IN teachers.hire_date%TYPE,
     insert_email IN teachers.email%TYPE)
     IS
     BEGIN
     INSERT INTO Teachers
     (employee_id,first_name,last_name,hire_date,email)
     VALUES
     (insert_employee_id,insert_first_name,insert_last_name,insert_hire_date,insert_email);
     END insert_teacher;


--Creating PROCEDURE to INSERT a Course 
CREATE PROCEDURE insert_course
    (insert_course_id IN courses.course_id%TYPE,
     insert_course_name IN courses.course_id%TYPE,     
     insert_start_date IN courses.start_date%TYPE,
     insert_class_room IN courses.class_room%TYPE)
     IS 
     BEGIN
     INSERT INTO Courses 
    (course_id,course_name,start_date,class_room)
    VALUES 
    (insert_course_id,insert_course_name,insert_start_date,insert_class_room);
     END insert_course;
     
--Creating PROCEDURE to INSERT a Register  
CREATE PROCEDURE insert_register
    (insert_course_id IN registration.course_id%TYPE,
     insert_course_name IN registration.course_name%TYPE,
     insert_schedule IN registration.schedule%TYPE,
     insert_student_id IN registration.student_id%TYPE,
     insert_employee_id IN registration.employee_id%TYPE)
     IS 
     BEGIN     
     INSERT INTO Registration
    (course_id,course_name,schedule,student_id,employee_id)
    VALUES 
    (insert_course_id,insert_course_name,insert_schedule,insert_student_id,insert_employee_id);
     END insert_register;
