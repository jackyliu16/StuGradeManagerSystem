-- Active: 1668709374912@@127.0.0.1@3306@CourseDB

USE CourseDB;

CREATE TABLE IF NOT EXISTS User (
    UserID  CHAR(11),
    UName   VARCHAR(32),
    UPwd    VARCHAR(32),
    Permission  TINYINT check(Permission > 0 and Permission < 4),
    PRIMARY KEY(UserID)
);
/* 1: Admin, 2: Teacher, 3: Student*/

INSERT INTO User VALUES('20200740029', 'jacky', 'Admin123', '1');
INSERT INTO User VALUES('20200740001', 'apple', '123456', '2');
INSERT INTO User VALUES('20200740002', 'banana', '123456', '3');

