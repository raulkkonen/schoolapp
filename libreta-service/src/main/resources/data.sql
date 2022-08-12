INSERT INTO tbl_libretas (id, descripcion, nota_final, student_id, course_id, created_user, created_date, row_version, status)
VALUES (1, 'Excelente participación', 16, 1, 1, 'kanoso','2020-11-21',0,'CREATED');

INSERT INTO tbl_libretas (id, descripcion, nota_final, student_id, course_id, created_user, created_date, row_version, status)
VALUES (2, 'Buena participación', 17, 2, 1, 'kanoso','2020-11-21',0,'CREATED');


INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (1, '1', 'I', 16, 'Excelente', 'kanoso','2020-11-21',0,'CREATED');
INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (2, '1', 'II', 18, 'Sigue asi', 'kanoso','2020-11-21',0,'CREATED');
INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (3, '1', 'III', 15, 'Vamos tu puedes', 'kanoso','2020-11-21',0,'CREATED');
INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (4, '1', 'IV', 19, 'Excelente', 'kanoso','2020-11-21',0,'CREATED');

INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (5, '2', 'I', 17, 'Excelente', 'kanoso','2020-11-21',0,'CREATED');
INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (6, '2', 'II', 19, 'Sigue asi', 'kanoso','2020-11-21',0,'CREATED');
INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (7, '2', 'III', 16, 'Vamos tu puedes', 'kanoso','2020-11-21',0,'CREATED');
INSERT INTO tbl_libreta_notas (id, libreta_id, bimestre, nota, observacion, created_user, created_date, row_version, status)
VALUES (8, '2', 'IV', 20, 'Excelente', 'kanoso','2020-11-21',0,'CREATED');
