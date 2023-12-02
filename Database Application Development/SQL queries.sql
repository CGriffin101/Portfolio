use Section4_Team05;

-- query 1
-- Orders whose price is over $1000.00 and have not been shipped yet

select order_Number as "Order Number"
from order_table
where order_Status != "Shipped"
	and order_Total >= 1000;

-- query 2
-- Customers whose phone number starts with area code 678

select concat(customer_FirstName," ", customer_LastName) as "Customer Name", customer_PhoneNumber as "Phone Number"
from customer
where customer_PhoneNumber like ("678-%");

-- query 3
-- all part models that have the brand of intel or amd

select part_Model as "Model",
	part_Brand as "Brand"
from part
where part_Brand in ("Intel","AMD");

-- query 4
-- displays order number, the customer's name for the order, the date and total of the order.
select order_Number as "Order Number",
	concat(customer_FirstName,' ',customer_LastName) as 'Customer Name',
    order_Date as 'Date of Order',
    order_Total as 'Order Total'
from customer cu join order_table orde
	on cu.customer_ID = orde.customer_ID
order by 1;

-- query 5
-- displays the order total before and after a hypothetical 20% increase in price
select order_Number as 'Order Number',
	order_Total as 'Order Total before increase',
    round((order_Total * 1.2),2) as 'Order Total after 20% increase'
from order_table
order by 1;

-- query 6
-- displays how many builds each customer has created. Does not display customers with no created builds. Ordered by most builds to least builds

select concat(cu.customer_FirstName,' ',cu.customer_LastName) as 'Name of Customer', count(*) as 'Number of Builds created'
from customer cu join order_table orde
	on cu.customer_ID = orde.customer_ID
	join build bu
    on orde.order_Number = bu.order_Number
group by 1
order by 2 desc,1;

-- query 7
-- displays a list of customers and their emails that placed their order in the same year as Cameron Liu

select customer.customer_ID as "Customer ID", 
	concat(customer_FirstName,' ',customer_LastName) as "Customer Name",
	customer_Email as "Customer email"
from order_table join customer
	on order_table.customer_ID = customer.customer_ID
where year(order_Date) = (select year(order_Date)
							from order_table join customer
							on order_table.customer_ID = customer.customer_ID
							where customer_FirstName = 'Cameron' and customer_LastName = 'Liu')
	and not(customer_FirstName = 'Cameron' and customer_LastName = 'Liu')
group by 1
order by 1;

