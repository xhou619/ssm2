# initialize t_student_id table.
INSERT IGNORE INTO t_student_id VALUES(1, '18030128');
INSERT IGNORE INTO t_student_id VALUES(2, '18030135');

# initialize t_class table.
INSERT IGNORE INTO t_class VALUES(1, 'Class 1, Software Technology, Grade 2016');
INSERT IGNORE INTO t_class VALUES(2, 'Class 2, Software Technology, Grade 2016');

# initialize t_student table.
INSERT IGNORE INTO t_student VALUES(1, 'john', 'f', 1, 1);
INSERT IGNORE INTO t_student VALUES(2, 'jack', 'm', 2, 1);

# initialize t_course table.
INSERT IGNORE INTO t_course VALUES(1, 'Java Programming Language', '08113226');
INSERT IGNORE INTO t_course VALUES(2, 'C Programming Language', '08113228');

# initialize t_course table.
INSERT IGNORE INTO t_elective_course VALUES(1, 1, 1);
INSERT IGNORE INTO t_elective_course VALUES(2, 1, 2);
INSERT IGNORE INTO t_elective_course VALUES(3, 2, 2);