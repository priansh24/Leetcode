# Write your MySQL query statement below
select contest_id, ifnull(round(count(distinct user_id)*100/(select count(user_id) from users),2),0) as percentage
from register
group by contest_id
order by percentage desc,contest_id;