
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE result INT;
    
    SET result = (
        CASE
            WHEN (SELECT COUNT(DISTINCT salary) FROM Employee) < N THEN NULL
            ELSE (
                SELECT salary
                FROM (
                    SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
                    FROM Employee
                ) AS ranked
                WHERE rnk = N
                LIMIT 1
            )
        END
    );
    
    RETURN result;
END