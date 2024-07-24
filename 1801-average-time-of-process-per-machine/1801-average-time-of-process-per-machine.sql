# Write your MySQL query statement below
-- select a.machine_id,
-- round(
--     (select avg(a1.timestamp) from activity a1 where a1.activity_type='end' and a1.machine_id=a.machine_id)-   (select avg(a1.timestamp) from activity a1 where a1.activity_type='start' and a1.machine_id=a.machine_id)
-- ,3) as processing_time from activity a group by a.machine_id;

select a1.machine_id, round(avg(a2.timestamp-a1.timestamp),3) as processing_time from activity a1
join activity a2
on a1.machine_id=a2.machine_id and a1.activity_type='start' and a2.activity_type='end'
group by a1.machine_id;