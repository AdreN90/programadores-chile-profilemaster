drop table if exists ACADEMIC_INFO;

drop table if exists PERSON;

drop table if exists TECHNOLOGY;

drop table if exists WORK_EXPERIENCE;

/*==============================================================*/
/* Table: ACADEMIC_INFO                                         */
/*==============================================================*/
create table ACADEMIC_INFO
(
   ID_PERSON            varchar(11) not null,
   ID_ACADEMICINFO      int not null,
   START_DATE           date not null,
   END_DATE             date not null,
   TYPE_EDUCATION       varchar(50) not null,
   EDUCATIONAL_INSTITUTION varchar(100) not null,
   primary key (ID_PERSON, ID_ACADEMICINFO)
);

/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/
create table PERSON
(
   ID_PERSON            varchar(11) not null,
   NAME                 varchar(50) not null,
   LAST_NAME            varchar(50) not null,
   DATE_OF_BIRTH        date not null,
   EMAIL                varchar(100) not null,
   ADDRESS              varchar(150) not null,
   CITY                 varchar(50) not null,
   COUNTRY              varchar(50) not null,
   CHANGE_OF_ADDRESS    boolean not null,
   primary key (ID_PERSON)
);

/*==============================================================*/
/* Table: TECHNOLOGY                                            */
/*==============================================================*/
create table TECHNOLOGY
(
   ID_PERSON            varchar(11) not null,
   ID_TECHNOLOGY        int not null,
   TECHNOLOGY           varchar(50) not null,
   primary key (ID_PERSON, ID_TECHNOLOGY)
);

/*==============================================================*/
/* Table: WORK_EXPERIENCE                                       */
/*==============================================================*/
create table WORK_EXPERIENCE
(
   ID_PERSON            varchar(11) not null,
   ID_WORK_EXPERIENCE   int not null,
   START_DATE           date not null,
   END_DATE             date not null,
   BUSINESS             varchar(100) not null,
   POSITION             varchar(100) not null,
   primary key (ID_PERSON, ID_WORK_EXPERIENCE)
);

alter table ACADEMIC_INFO add constraint FK_REFERENCE_2 foreign key (ID_PERSON)
      references PERSON (ID_PERSON) on delete restrict on update restrict;

alter table TECHNOLOGY add constraint FK_REFERENCE_1 foreign key (ID_PERSON)
      references PERSON (ID_PERSON) on delete restrict on update restrict;

alter table WORK_EXPERIENCE add constraint FK_REFERENCE_3 foreign key (ID_PERSON)
      references PERSON (ID_PERSON) on delete restrict on update restrict;
