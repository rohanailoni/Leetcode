SELECT 
   Department.name as "Department",
   Employee.name as "Employee",
   Employee.salary
FROM 
    Employee
inner join 
    Department on Employee.departmentId=Department.id
WHERE 
    (departmentId,salary) in
    (select 
        DepartmentId, MAX(Salary)
        FROM
            Employee
        GROUP BY DepartmentId
    )
;