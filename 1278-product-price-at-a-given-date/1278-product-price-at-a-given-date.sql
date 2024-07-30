# Write your MySQL query statement below
select t1.product_id, ifnull(t2.new_price,10) as price
from (
    select distinct product_id from products
) as t1
left join (
    select product_id,new_price
    from products
    where (product_id,change_date) in (
        select product_id, max(change_date) as last_date
        from products
        where change_date<='2019-08-16'
        group by product_id
    )
) as t2
using (product_id);