drop table if exists ACADEMICINFORMATION;

drop table if exists PERSON;

drop table if exists TECHNOLOGY;

drop table if exists WORKEXPERIENCIE;

/*==============================================================*/
CREATE TABLE ACADEMICINFORMATION (
    ID_PERSON VARCHAR(11) NOT NULL,
    ID_ACADEMICINFO INT NOT NULL,
    START_DATE DATE NOT NULL,
    END_DATE DATE NOT NULL,
    TYPE_EDUCATION VARCHAR(50) NOT NULL,
    EDUCATIONAL_INSTITUTION VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID_PERSON , ID_ACADEMICINFO)
);

/*==============================================================*/
CREATE TABLE PERSON (
    ID_PERSON VARCHAR(11) NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    DATE_OF_BIRTH DATE NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    ADDRESS VARCHAR(150) NOT NULL,
    CITY VARCHAR(50) NOT NULL,
    COUNTRY VARCHAR(50) NOT NULL,
    CHANGE_OF_ADDRESS BOOLEAN NOT NULL,
    PRIMARY KEY (ID_PERSON)
);

/*==============================================================*/
CREATE TABLE TECHNOLOGY (
    ID_PERSON VARCHAR(11) NOT NULL,
    ID_TECHNOLOGY INT NOT NULL,
    TECHNOLOGY VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID_PERSON , ID_TECHNOLOGY)
);

/*==============================================================*/
CREATE TABLE WORKEXPERIENCIE (
    ID_PERSON VARCHAR(11) NOT NULL,
    ID_WORK_EXPERIENCE INT NOT NULL,
    START_DATE DATE NOT NULL,
    END_DATE DATE NOT NULL,
    BUSINESS VARCHAR(100) NOT NULL,
    POSITION VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID_PERSON , ID_WORK_EXPERIENCE)
);

alter table ACADEMICINFORMATION add constraint FK_REFERENCE_2 foreign key (ID_PERSON)
      references PERSON (ID_PERSON) on delete restrict on update restrict;

alter table TECHNOLOGY add constraint FK_REFERENCE_1 foreign key (ID_PERSON)
      references PERSON (ID_PERSON) on delete restrict on update restrict;

alter table WORKEXPERIENCIE add constraint FK_REFERENCE_3 foreign key (ID_PERSON)
      references PERSON (ID_PERSON) on delete restrict on update restrict;