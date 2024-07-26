# Write your MySQL query statement below
-- select "Low Salary" as category, sum(income < 20000) as accounts_count
-- from accounts
-- union
-- select "Average Salary" as category, sum(income between 20000 and 50000) as accounts_count
-- from accounts
-- union
-- select "High Salary" as category, sum(income  > 50000) as accounts_count
-- from accounts;

select "Low Salary" as category, count(income) as accounts_count
from accounts where income < 20000
union
select "Average Salary" as category, count(income) as accounts_count
from accounts where income between 20000 and 50000
union
select "High Salary" as category, count(income) as accounts_count
from accounts where income  > 50000;
