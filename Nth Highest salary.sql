-- Question 50
-- Write a SQL query to get the nth highest salary from the Employee table.

-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- For example, given the above Employee table, the nth highest salary where n = 2 is 200. 
--If there is no nth highest salary, then the query should return null.

-- +------------------------+
-- | getNthHighestSalary(2) |
-- +------------------------+
-- | 200                    |
-- +------------------------+

--Solution
CREATE FUNCTION getNthHighestSalary(N INT) RETURN INT
BEGIN
    RETURN(
        SELECT DISTINCT a.salary
        FROM 
        (SELECT salary,
        dense_rank() OVER (ORDER BY salary DESC) AS dense_rank
        FROM Employee) a
        WHERE a.dense_rank= N
    );
END;
