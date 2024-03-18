SELECT id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (
            SELECT DISTINCT p_id
            FROM (
                SELECT t1.id AS p_id, t2.id AS c_id
                FROM Tree t1
                LEFT OUTER JOIN Tree t2 ON t1.id = t2.p_id
            ) tb
            WHERE c_id IS NOT NULL
        ) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM Tree;