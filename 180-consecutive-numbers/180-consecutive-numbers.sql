# Write your MySQL query statement below
select 
    distinct a.num as ConsecutiveNums
from 
    Logs a,Logs b,Logs c
where 
    a.Id+1=b.Id and
    b.Id+1=c.Id and
    a.num=b.num and
    b.num=c.num;
