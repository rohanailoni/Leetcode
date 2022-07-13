select ifnull((SELECT DISTINCT Salary 
                AS 
            SecondHighestSalary 
            FROM 
                Employee e2 
            ORDER BY 
                Salary 
            DESC LIMIT 1 OFFSET 1 ),null) as SecondHighestSalary;