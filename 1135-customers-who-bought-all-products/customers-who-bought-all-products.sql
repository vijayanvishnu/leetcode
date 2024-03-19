# Write your MySQL query statement below
SELECT customer_id
FROM (SELECT *
FROM Customer
GROUP BY
customer_id,product_key) tb
GROUP BY 
customer_id
HAVING COUNT(product_key) = (SELECT COUNT(*) FROM Product);
