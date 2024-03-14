# Write your MySQL query statement below
SELECT id ,
    CASE 
        WHEN MOD(row_no,2) = 1 THEN COALESCE(next,student)
        ELSE prev
    END student
FROM
(SELECT * ,
LAG(student) OVER() prev,
LEAD(student) OVER() next,
ROW_NUMBER() OVER() row_no
FROM
Seat) t;