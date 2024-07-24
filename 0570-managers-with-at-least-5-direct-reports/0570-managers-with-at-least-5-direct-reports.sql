# Write your MySQL query statement below
-- select e.name from employee e where count(e.managerId)>=5 grouped by e.id;

select e1.name
from employee e1
join
    (select managerId,count(*) as directReports
    from employee
    group by managerId
    having count(*)>=5)
e2 on e1.id = e2.managerId;
