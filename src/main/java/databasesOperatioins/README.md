# StuGradeManagerSystem

## requirements

Adding jar from lab folder's into your Java project management framework

## Current implementation

Finish basic implement framework => due to the requirements of upper-level application is not clear, thus we just
implement some basically function

### Current function Provide Upwards

#### Check

1. `checkIfStudentInCourse`:    connect all Course and ExClass To find out if student is learned from the course;
2. `checkIfStudentInExCourse`:  as it's name

#### Insert

1. `insertStudentIntoExCourse`:will add a record of student select course [which means that student grade will be default in null]
2. `updateStudentExCourseGrade`: will update a student grade(also will check if student in the course, if not also will return a false)


### the function may will be provide in future

#### improvements that may occur

Convert All bool output into a kind of exception, for Internal logic have a better control of the down-level support

#### check

1. studentLoginInCheck(user_id: String, user_pwd: String) -> bool:
2. teacherLoginInCheck(user_id: String, user_pwd: String) -> bool:
3. adminLoginInCheck(user_id: String, user_pwd: String) -> bool:
4. ifTeacherTechingExCourse(techNo: String, ex_course_no: String) -> bool:


#### insert
1. createTeacher(TechNo: String, TechPwd: String) -> bool:  // StuNo TechNo should be gain from databases or input a new one(two choice)
2. createStudent(StuNo: String, StuPwd: String) -> bool:
3. createTeacher(TechNo: String) -> bool:   BC Tech and Stu have a kind of default password
4. createStudent(StuNo: String) -> bool:
5. createAdmin(AdminNo: String, AdminPwd: String) -> bool:
6. insertStudentIntoExCourse(StuNo: String, ExClassNo: String) -> bool:
7. insertTeacherIntoExCourse(TechNo: String, ExClassNo: String) -> bool:
8. createExClassFromCourse(CourseNo: String, year: Year[default this year],semester) -> bool: ExClassNo should be gain in database (get the last one)
9. createCourse(CourseName: String) -> bool:


#### update

1. updateStuGrade(StuNo: String, ExClassNo: String) -> bool:
2. updatePassword[ Student, Teacher, Admin ].etc
3. 


#### delete

1. deleteStudentInExClass(StuNo: String, ExClassNo: String) -> bool:
2. deleteTeacherInExClass(StuNo: String, ExClassNo: String) -> bool:
3. deleteUser[ teacher, student, admin ].etc
4. 