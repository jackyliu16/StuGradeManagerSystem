-- Active: 1668709374912@@127.0.0.1@3306@CourseDB

# use For DDL Rebuild DROP DATABASE CourseDB;



CREATE database CourseDB;



USE CourseDB;

/* 
 4: dept, major
 8: course, ExClassNo
 11: StuNo, TechNo, 
 32: everything need to type
 */

CREATE TABLE
    IF NOT EXISTS Department(
        DeptNo char(4) NOT NULL,
        DeptName char(32) NOT NULL,
        PRIMARY KEY(DeptNo)
    );

CREATE TABLE
    IF NOT EXISTS Major(
        MajorNo char(4) NOT NULL,
        MajorName char(32) NOT NULL,
        DeptNo char(4) NOT NULL,
        PRIMARY KEY(MajorNo),
        Foreign Key (DeptNo) REFERENCES Department(DeptNo)
    );

CREATE TABLE
    IF NOT EXISTS Teacher(
                             TechNo   char(11)    NOT NULL,
                             TechName char(32)    NOT NULL,
                             DeptNo   char(4)     NOT NULL,
                             Pwd      varchar(32) not null,
                             PRIMARY KEY (TechNo),
                             Foreign Key (DeptNo) REFERENCES Department (DeptNo)
);

CREATE TABLE
    IF NOT EXISTS Student
(
    StuNo   char(11)    NOT NULL,
    StuName varchar(32) NOT NULL,
    MajorNo char(4)     NOT NULL,
    Pwd     varchar(32) not null,
    PRIMARY KEY (StuNo),
    Foreign Key (MajorNo) REFERENCES Major (MajorNo)
);

CREATE table
    if not exists Course(
        CourseNo char(8) PRIMARY KEY,
        CourseName char(32) NOT NULL
        /* MajorNo     char(8)     not null, */
        /* Foreign Key (MajorNo) REFERENCES Major(MajorNo) */
    );

CREATE TABLE
    IF NOT EXISTS ExClass(
        ExClassNo char(8) NOT NULL,
        # TODO 如果确定要修改成无直接关系，则需要修改这个大小
        CourseNo char(8) NOT NULL,
        Year numeric(4, 0) check(
            year > 1980
            and year < 2100
        ),
        semester varchar(6),
        PRIMARY KEY(ExClassNo),
        Foreign Key (CourseNo) REFERENCES Course(CourseNo)
    );

CREATE TABLE
    IF NOT EXISTS Learn
(
    StuNo     char(11) NOT NULL,
    ExClassNo char(8)  NOT NULL,
    Grade     DECIMAL(5, 2) check (
                Grade >= 0.00
            and Grade <= 100.00
        ),
    PRIMARY KEY (StuNo, ExClassNo),
    Foreign Key (StuNo) REFERENCES Student (StuNo),
    Foreign Key (ExClassNo) REFERENCES ExClass (ExClassNo)
);

CREATE TABLE
    IF NOT EXISTS Teaching(
        TechNo char(11) NOT NULL,
        ExClassNo char(8) NOT NULL,
        PRIMARY KEY(TechNo, ExClassNo)
    );

CREATE TABLE
    Admin (
        ID char(11) PRIMARY KEY,
        Password char(32)
    )