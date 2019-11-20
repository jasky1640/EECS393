-- Database: CSCGS

-- DROP DATABASE "CSCGS";

CREATE DATABASE "CSCGS"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.936'
    LC_CTYPE = 'English_United States.936'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- SCHEMA: courses

-- DROP SCHEMA courses ;

CREATE SCHEMA courses
    AUTHORIZATION postgres;
	
-- SCHEMA: user_information

-- DROP SCHEMA user_information ;

CREATE SCHEMA user_information
    AUTHORIZATION postgres;

-- Table: user_information.user_information

-- DROP TABLE user_information.user_information;

CREATE TABLE user_information.user_information
(
    user_id integer NOT NULL DEFAULT nextval('user_information.user_information_user_id_seq'::regclass),
    user_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    user_password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    user_type smallint NOT NULL,
    core character varying(1000) COLLATE pg_catalog."default",
    breadth character varying(1000) COLLATE pg_catalog."default",
    depth character varying(1000) COLLATE pg_catalog."default",
    general character varying(1000) COLLATE pg_catalog."default",
    technical_elective character varying(1000) COLLATE pg_catalog."default",
    track smallint,
    CONSTRAINT user_information_pkey PRIMARY KEY (user_id)
)

TABLESPACE pg_default;

ALTER TABLE user_information.user_information
    OWNER to postgres;

-- Table: courses.course

-- DROP TABLE courses.course;

CREATE TABLE courses.course
(
    course_id integer NOT NULL DEFAULT nextval('courses.course_course_id_seq'::regclass),
    course_code character varying(50) COLLATE pg_catalog."default" NOT NULL,
    name character varying(500) COLLATE pg_catalog."default" NOT NULL,
    time_slots character varying(500) COLLATE pg_catalog."default" NOT NULL,
    prerequisite_courses character varying(500) COLLATE pg_catalog."default",
    type character varying(10) COLLATE pg_catalog."default" NOT NULL,
    depth smallint,
    credit_hour smallint,
    CONSTRAINT course_pkey PRIMARY KEY (course_id)
)

TABLESPACE pg_default;

ALTER TABLE courses.course
    OWNER to postgres;
	
-- Data in Table course

INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('45','EECS391','Introduction to Artificial Intelligence','24010001115','EECS132','00111','6','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('46','EECS393','Software Engineering','13510351125','EECS233','00111','1','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('44','EECS345','Programming Language Concepts','13515201610','EECS302EECS233','00111','1','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('65','EECS488','Embedded Systems Design','40018302130',NULL,'00001',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('1','CHEM111','Principles of Chemistry for Engineers','1351035112520010001050',NULL,'10000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('2','ENGR145','Chemistry of Materials','1351035112520008300920','CHEM111','10000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('3','MATH121','Calculus for Science and Engineering I','13509301020',NULL,'10000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('4','MATH122','Calculus for Science and Engineering II','1350930102020011301220','MATH121','10000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('5','MATH223','Calculus for Science and Engineering III','13509301020','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('6','MATH223','Calculus for Science and Engineering III','13511401230','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('7','MATH223','Calculus for Science and Engineering III','24010001115','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('8','MATH223','Calculus for Science and Engineering III','24013001415','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('9','MATH223','Calculus for Science and Engineering III','24011301245','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('10','MATH223','Calculus for Science and Engineering III','13511401230','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('11','MATH201','Introduction to Linear Algebra for Applications','13509301020',NULL,'10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('12','MATH201','Introduction to Linear Algebra for Applications','24013001415',NULL,'10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('13','EECS132','Introduction to Programming in Java','1351415150530015201610',NULL,'01000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('14','EECS233','Introduction to Data Structures','24013001415','EECS132','01000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('15','MATH307','Linear Algebra','13510351125',NULL,'10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('16','MATH307','Linear Algebra','13509301020',NULL,'10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('17','PHYS121','General Physics I - Mechanics','1351140123020017302030',NULL,'10000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('18','EECS281','Logic Design and Computer Organization','2401000111520013001350','EECS132','01000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('19','PHYS122','General Physics II - Electricity and Magnetism','1350930102020017302030','PHYS121','10000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('20','EECS302','Discrete Mathematics','13509301020','MATH122','01000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('21','ENGR398','Professional Communication for Engineers','20011301220',NULL,'10000',NULL,'1')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('22','ENGL398','Professional Communication for Engineers','13017301820',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('23','ENGL398','Professional Communication for Engineers','13008250915',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('24','ENGL398','Professional Communication for Engineers','13009301020',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('25','ENGL398','Professional Communication for Engineers','13010351125',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('26','ENGL398','Professional Communication for Engineers','13011401230',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('27','ENGL398','Professional Communication for Engineers','13012451335',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('28','ENGL398','Professional Communication for Engineers','13014151505',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('29','ENGL398','Professional Communication for Engineers','13016251715',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('30','ENGL398','Professional Communication for Engineers','13015201610',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('31','ENGL398','Professional Communication for Engineers','24013001350',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('32','ENGL398','Professional Communication for Engineers','24014301520',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('33','ENGL398','Professional Communication for Engineers','24016001650',NULL,'10000',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('36','EECS395','Senior Project in Computer Science','13511401230','EECS340','01000',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('37','EECS314','Computer Architecture','13516251715','EECS281','00101',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('38','EECS325','Computer Networks I','24013001415','EECS233','00111','3','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('39','STAT312','Basic Statistics for Engineering and Science','24010001115','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('40','STAT312','Basic Statistics for Engineering and Science','24013001415','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('41','STAT312','Basic Statistics for Engineering and Science','24014301545','MATH122','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('34','EECS340','Algorithms','13012451400','EECS302EECS233','00111','25','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('35','EECS340','Algorithms','24013001415','EECS302EECS233','00111','25','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('42','EECS338','Intro to Operating Systems and Concurrent Programming','2401600171530017301820','EECS233','00111','3','4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('43','EECS341','Introduction to Database Systems','24014301545','EECS302EECS233','00111','45','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('47','EECS337','Compiler Design','20019002130','EECS233EECS281','00011','13','4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('48','EECS337','Compiler Design','30016251715','EECS233EECS281','00011','13','4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('49','EECS402','Internet Security and Privacy','24014301545','EECS325','00011','13','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('50','EECS454','Analysis of Algorithms','13012451400','EECS340','00011','2','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('51','MATH408','Introduction to Cryptology','13511401230','MATH303','00011','23','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('52','EECS433','Database Systems','24008300945','EECS341','00011','4','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('53','EECS459','Bioinformatics for Systems Biology','13514151505','EECS458','00011','5','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('54','EECS442','Causal Learning from Data','13514151505','STAT312','00011','6','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('55','EECS442','Causal Learning from Data','13514151505','MATH380','00011','6','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('56','MATH380','Introduction to Probability','13510351125','MATH223','10000',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('57','EECS290','Introduction to Computer Game Design and Implementation','24008300945','EECS132','00001',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('58','EECS491','Artificial Intelligence: Probabilistic Graphical Models','13012451400','EECS391','00011','6','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('59','EECS499','Algorithmic Robotics','13012451400','EECS391','00011','6','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('60','EECS531','Computer Vision','13510351125','EECS391','00011','6','3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('61','EECS301','Digital Logic Laboratory','50014151505','EECS281','00001',NULL,'2')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('62','EECS315','Digital Systems Design','24013001415','EECS281','00001',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('63','EECS317','Computer Design - FPGAs','20014301645','EECS281','00001',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('67','EECS309','Electromagnetic Fields I','13514151505','EECS246','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('64','EECS245','Electronic Circuits','1301245140020014301615','ENGR210','00002',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('66','EECS304','Control Engineering I with Laboratory','13015201635','EECS246','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('68','EECS313','Signal Processing','24014301545','EECS246','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('69','EECS305','Control Engineering I Laboratory','50013001430','EECS304','00002',NULL,'1')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('70','EECS354','Digital Communications','24019002015','EECS246','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('71','EECS413','Nonlinear Systems I','13017001815','EECS408','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('72','ENGR210','Introduction to Circuits and Instrumentation','1350930102010015201720',NULL,'00002',NULL,'4')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('82','MATH308','Introduction to Abstract Algebra','13509301020','MATH122','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('83','MATH330','Introduction of Scientific Computing','24013001415','MATH224','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('84','PHYS221','Introduction to Modern Physics','1351520161040010001050','PHYS122','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('85','PHYS221','Introduction to Modern Physics','1351520161040013001350','PHYS122','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('86','PHYS250','Computational Methods in Physics','13514151505','EECS132MATH224','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('73','MATH224','Elementary Differential Equations','13511401230','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('74','MATH224','Elementary Differential Equations','13510351125','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('75','MATH224','Elementary Differential Equations','13509301020','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('76','MATH224','Elementary Differential Equations','13510351125','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('77','MATH224','Elementary Differential Equations','24010001115','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('78','MATH224','Elementary Differential Equations','13514151505','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('79','MATH224','Elementary Differential Equations','24013001415','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('80','MATH224','Elementary Differential Equations','24014300545','MATH223','00002',NULL,'3')
INSERT INTO courses.course (course_id,course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour) VALUES ('81','MATH224','Elementary Differential Equations','13511401230','MATH223','00002',NULL,'3')

-- Data in Table user_information

INSERT INTO user_information.user_information (user_id,user_name,user_password,user_type,core,breadth,depth,general,technical_elective) VALUES ('1','zhizhi','123456','1',NULL,NULL,NULL,NULL,NULL)