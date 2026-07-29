# initialize t_student_id table.
INSERT IGNORE INTO t_student_id VALUES(1, '18030128');
INSERT IGNORE INTO t_student_id VALUES(2, '18030135');

# initialize t_class table.
INSERT IGNORE INTO t_class VALUES(1, 'Class 1, Software Technology, Grade 2016');
INSERT IGNORE INTO t_class VALUES(2, 'Class 2, Software Technology, Grade 2016');

# initialize t_student table.
INSERT IGNORE INTO t_student VALUES(1, 'john', 'f', 1, 1);
INSERT IGNORE INTO t_student VALUES(2, 'jack', 'm', 2, 1);