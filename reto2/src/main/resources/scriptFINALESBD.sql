create database g5r2;
use g5r2;

INSERT INTO user (dni, password) VALUES ('00000000P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('11111111P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('22222222P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('33333333P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('44444444P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('55555555P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('66666666P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('77777777P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('88888888P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('99999999P', '8CB2237D0679CA88DB6464EAC60DA96345513964');
INSERT INTO user (dni, password) VALUES ('admin', 'D033E22AE348AEB5660FC2140AEC35850C4DA997');


INSERT INTO role (roleID, role) VALUES (1, 'Admin');
INSERT INTO role (roleID, role) VALUES (2, 'Professor');
INSERT INTO role (roleID, role) VALUES (3, 'Student');

INSERT INTO user_role (user_DNI,role_ID) VALUES ( 'admin',1);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '00000000P',1);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '11111111P',2);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '22222222P',2);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '33333333P',2);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '44444444P',3);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '55555555P',3);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '66666666P',3);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '77777777P',3);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '88888888P',3);
INSERT INTO user_role (user_DNI,role_ID) VALUES ( '99999999P',3);


INSERT INTO professor (professor_dni, name, surname, nationality, email, addres,photo) VALUES ('11111111P', 'Borja', 'Saiz', 'Spain', 'borja@elorrieta.com', 'Bilbao',"src/main/resources/static/images/22345678A.jpg");
INSERT INTO professor (professor_dni, name, surname, nationality, email, addres,photo) VALUES ('22222222P', 'Mikel', 'Crego', 'Spain', 'mikel@elorrieta.com', 'Barakaldo',"src/main/resources/static/images/22345678A.jpg");
INSERT INTO professor (professor_dni, name, surname, nationality, email, addres,photo) VALUES ('33333333P', 'Gari', 'Bilbao', 'Spain', 'borja@elorrieta.com', 'Bilbao',"src/main/resources/static/images/22345678A.jpg");


INSERT INTO student (student_dni, born_date, email, name,  nationality,  phone, photo,surname) VALUES ('44444444P', '2001-01-01','aga@elorrieta.com','Aga','RD Congo', '644444444',"src/main/resources/static/images/22345678A.jpg",    'Mambu');
INSERT INTO student (student_dni, born_date, email, name,  nationality,  phone,photo,surname) VALUES ('55555555P', '2001-01-01','aga@elorrieta.com','Ibai',  'Spain','655555555',"src/main/resources/static/images/22345678A.jpg", 'Gonzalez');
INSERT INTO student (student_dni, born_date, email, name,  nationality,  phone,photo,surname) VALUES ('66666666P', '2001-01-01','aga@elorrieta.com','Dani',  'Spain',  '666666666',"src/main/resources/static/images/22345678A.jpg",  'Guillen');
INSERT INTO student (student_dni, born_date, email, name,  nationality,  phone,photo,surname) VALUES ('77777777P', '2001-01-01','aga@elorrieta.com','Eneko',   'Spain',  '677777777',"src/main/resources/static/images/22345678A.jpg",'Garcia');
INSERT INTO student (student_dni, born_date, email, name,  nationality,  phone,photo,surname) VALUES ('88888888P', '2001-01-01','aga@elorrieta.com','Adrian',  'Spain',  '688888888',"src/main/resources/static/images/22345678A.jpg", 'Gonzalez');
INSERT INTO student (student_dni, born_date, email, name,  nationality,  phone,photo,surname) VALUES ('99999999P', '2001-01-01','aga@elorrieta.com','Iñaki',   'Spain',  '699999999',"src/main/resources/static/images/22345678A.jpg", 'Rioja');




INSERT INTO grade (grade_ID, name, language) VALUES (1, 'DAM', 'ES');
INSERT INTO grade (grade_ID, name, language) VALUES (2, 'DAW', 'ES');
INSERT INTO grade (grade_ID, name, language) VALUES (3, 'ASIR', 'ES');


INSERT INTO grade_EDITION (grade_Edition_ID, grade_ID, tutor_DNI, fecha) VALUES (1, 1, '11111111P', '2022-01-01');
INSERT INTO grade_EDITION (grade_Edition_ID, grade_ID, tutor_DNI, fecha) VALUES (2, 2, '22222222P', '2022-01-01');
INSERT INTO grade_EDITION (grade_Edition_ID, grade_ID, tutor_DNI, fecha) VALUES (3, 3, '33333333P', '2022-01-01');



INSERT INTO promotion (grade_ed_id, student_dni) VALUES (1, '44444444P');
INSERT INTO promotion (grade_ed_id, student_dni) VALUES (1, '55555555P');
INSERT INTO promotion (grade_ed_id, student_dni) VALUES (1, '77777777P');
INSERT INTO promotion (grade_ed_id, student_dni) VALUES (2, '88888888P');
INSERT INTO promotion (grade_ed_id, student_dni) VALUES (2, '99999999P');
INSERT INTO promotion (grade_ed_id, student_dni) VALUES (3, '66666666P');



INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (1, 1, '11111111P', 'PMD','200');
INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (2, 1, '11111111P', 'ADT', '200');
INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (3, 1, '33333333P', 'DIN','200');

INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (4, 2, '22222222P', 'DMP', '200');
INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (5, 2, '22222222P', 'TDA', '200');
INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (6, 2, '11111111P', 'NID', '200');

INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (7, 3, '33333333P', 'MPD', '200');
INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (8, 3, '11111111P', 'DAT', '200');
INSERT INTO subject (subject_ID, grade_ed_id, professor_DNI, name, duration) VALUES (9, 3, '22222222P', 'IDN', '200');



INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (1, '44444444P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (1, '55555555P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (1, '66666666P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (1, '77777777P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (1, '88888888P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (1, '99999999P', 5, 5, 5, 5, 5);

INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (2, '44444444P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (2, '55555555P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (2, '66666666P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (2, '77777777P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (2, '88888888P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (2, '99999999P', 5, 5, 5, 5, 5);

INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (3, '44444444P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (3, '55555555P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (3, '66666666P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (3, '77777777P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (3, '88888888P', 5, 5, 5, 5, 5);
INSERT INTO note (subject_ID, student_dni, eva1, eva2, eva3, final1, final2) VALUES (3, '99999999P', 5, 5, 5, 5, 5);

INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('44444444P', 1,'2001-01-01', true);
INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('44444444P', 2,'2001-01-01', false);
INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('55555555P', 3,'2001-01-01', true);
INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('55555555P', 4,'2001-01-01', false);
INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('66666666P', 5,'2001-01-01', true);
INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('66666666P', 6,'2001-01-01', false);
INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('77777777P', 7,'2001-01-01', true);
INSERT INTO absence (student_dni, subject_id, foul,justified) VALUES ('77777777P', 8,'2001-01-01', false);