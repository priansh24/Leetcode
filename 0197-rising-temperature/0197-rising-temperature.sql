# Write your MySQL query statement below
SELECT id FROM weather w1 where temperature > (select temperature from weather w2 where w2.recordDate=DATE_SUB(w1.recordDate, Interval 1 Day));