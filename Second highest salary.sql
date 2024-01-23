-- Question 15
-- Write a SQL query to get the second highest salary from the Employee table.

-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- For example, given the above Employee table, the query should return 200 as the second highest salary. 
-- If there is no second highest salary, then the query should return null.

-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+

--Solution--
SELECT IFNULL((
SELECT Salary
FROM Employee
ORDER BY Salary DESC
LIMIT 1 OFFSET 1),NULL) AS SecondHighestSalary;

--Solution 02--
SELECT MAX(salary) AS SecondHighestSalary
FROM  Employee
WHERE salary !=(SELECT MAX(salary) FROM Employee);