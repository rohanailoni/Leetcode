# Write your MySQL query statement below
select 
    d.name as "Department",
    al.name as `Employee`,
    al.salary as `salary`
from
    Employee al
inner join 
    Department d
on 
    al.departmentId=d.id
where
    (select 
        count(distinct(be.salary))
     from 
        Employee be
     where 
        be.salary>al.salary and be.departmentId=al.departmentId
    )<3
;