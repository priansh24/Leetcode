# Write your MySQL query statement below
select e.name,b.bonus from employee e left join bonus b on b.empId=e.empId where b.bonus is null or b.bonus<1000;