/* Write your PL/SQL query statement below */
select eid.unique_id as unique_id, e.name as name
from employees e left join employeeUNI eid on e.id = eid.id;