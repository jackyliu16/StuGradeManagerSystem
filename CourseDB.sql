-- Active: 1668709374912@@127.0.0.1@3306@CourseDB

CREATE DATABASE IF NOT EXISTS CourseDB;

USE CourseDB;
/* 
4: dept, major
8: course, ExClassNo
11: StuNo, TechNo, 
32: everything need to type
 */
CREATE TABLE IF NOT EXISTS Department(
    DeptNo      char(4),
    DeptName    char(32),
    PRIMARY KEY(DeptNo)
);

CREATE TABLE IF NOT EXISTS Major(
    MajorNo     char(4),
    MajorName   char(32),
    DeptNo      char(4),
    PRIMARY KEY(MajorNo),
    Foreign Key (DeptNo) REFERENCES Department(DeptNo)
);

CREATE TABLE IF NOT EXISTS Teacher(
    TechNo      char(11)    NOT NULL,
    TechName    char(32)    NOT NULL,
    DeptNo      char(4)     NOT NULL,
    PRIMARY KEY(TechNo),
    Foreign Key (DeptNo) REFERENCES Department(DeptNo)
);

CREATE TABLE IF NOT EXISTS Student(
    StuNo       char(11),
    StuName     varchar(32),
    MajorNo     char(4),
    PRIMARY KEY(StuNo),
    Foreign Key (MajorNo) REFERENCES Major(MajorNo)
);

CREATE table if not exists Course(
    CourseNo    char(8)     PRIMARY KEY,
    CourseName  char(32)    not null
    /* MajorNo     char(8)     not null, */
    /* Foreign Key (MajorNo) REFERENCES Major(MajorNo) */
);

CREATE TABLE IF NOT EXISTS ExClass(
    ExClassNo   char(8), # TODO 如果确定要修改成无直接关系，则需要修改这个大小
    CourseNo    char(8),
    PRIMARY KEY(ExClassNo),
    Foreign Key (CourseNo) REFERENCES Course(CourseNo)
);

CREATE TABLE IF NOT EXISTS Learn(
    StuNo       char(11),
    ExClassNo   char(8),
    Grade       DECIMAL(4, 2) check(Grade >= 0 and Grade <= 100) DEFAULT(0),
    PRIMARY KEY (StuNo, ExClassNo),
    Foreign Key (StuNo) REFERENCES Student(StuNo),
    Foreign Key (ExClassNo) REFERENCES ExClass(ExClassNo) 
);

CREATE TABLE IF NOT EXISTS Teaching(
    TechNo      char(11),
    ExClassNo   char(8)
);


