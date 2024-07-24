# Write your MySQL query statement below
select round(count(distinct player_id)/(select count(distinct player_id) from activity),2) as fraction
from activity
where (player_id,Date_SUB(event_date,interval 1 Day))
in
(Select player_id,min(event_date) as first_login from activity group by player_id)
;