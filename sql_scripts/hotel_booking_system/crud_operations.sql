USE hotel_booking_service;

-- 25 insertion statements
-- Hotels
INSERT INTO hotels (hotel_name, address, city, state, country, phone) VALUES ('Ocean View', '123 Beach Ave', 'Miami', 'FL', 'USA', '3051234567');
INSERT INTO hotels (hotel_name, address, city, state, country, phone) VALUES ('Mountain Retreat', '456 Hill St', 'Denver', 'CO', 'USA', '7209876543');
INSERT INTO hotels (hotel_name, address, city, state, country, phone) VALUES ('City Center Inn', '789 Downtown St', 'New York', 'NY', 'USA', '2126543210');
INSERT INTO hotels (hotel_name, address, city, state, country, phone) VALUES ('Lakeside Resort', '321 Lake Dr', 'Chicago', 'IL', 'USA', '7731112222');

-- Room Types
INSERT INTO room_types (room_type_name) VALUES ('Single');
INSERT INTO room_types (room_type_name) VALUES ('Double');
INSERT INTO room_types (room_type_name) VALUES ('Suite');
INSERT INTO room_types (room_type_name) VALUES ('Deluxe Suite');

-- Rooms
INSERT INTO rooms (hotel_id, room_type_id, room_number, price_per_night, availability_status) VALUES (1, 1, '101', 120.00, TRUE);
INSERT INTO rooms (hotel_id, room_type_id, room_number, price_per_night, availability_status) VALUES (1, 2, '102', 200.00, TRUE);
INSERT INTO rooms (hotel_id, room_type_id, room_number, price_per_night, availability_status) VALUES (2, 3, '201', 300.00, FALSE);
INSERT INTO rooms (hotel_id, room_type_id, room_number, price_per_night, availability_status) VALUES (3, 4, '301', 400.00, TRUE);

-- Customers
INSERT INTO customers (first_name, last_name, email, phone) VALUES ('John', 'Doe', 'john.doe@example.com', '1234567890');
INSERT INTO customers (first_name, last_name, email, phone) VALUES ('Jane', 'Smith', 'jane.smith@example.com', '9876543210');
INSERT INTO customers (first_name, last_name, email, phone) VALUES ('Emily', 'Davis', 'emily.davis@example.com', '4567891230');
INSERT INTO customers (first_name, last_name, email, phone) VALUES ('Michael', 'Brown', 'michael.brown@example.com', '7891234560');

-- Bookings
INSERT INTO bookings (customer_id, room_id, booking_date, check_in_date, check_out_date, total_price, payment_status) VALUES (1, 1, '2024-10-01', '2024-10-10', '2024-10-15', 600.00, FALSE);
INSERT INTO bookings (customer_id, room_id, booking_date, check_in_date, check_out_date, total_price, payment_status) VALUES (2, 2, '2024-09-15', '2024-09-20', '2024-09-25', 1000.00, TRUE);
INSERT INTO bookings (customer_id, room_id, booking_date, check_in_date, check_out_date, total_price, payment_status) VALUES (3, 3, '2024-08-10', '2024-08-15', '2024-08-20', 1500.00, FALSE);
INSERT INTO bookings (customer_id, room_id, booking_date, check_in_date, check_out_date, total_price, payment_status) VALUES (4, 4, '2024-07-05', '2024-07-10', '2024-07-15', 2000.00, TRUE);

-- Payments
INSERT INTO payments (booking_id, payment_date, amount, payment_method) VALUES (1, '2024-10-01', 600.00, 'Credit Card');
INSERT INTO payments (booking_id, payment_date, amount, payment_method) VALUES (2, '2024-09-20', 1000.00, 'Debit Card');
INSERT INTO payments (booking_id, payment_date, amount, payment_method) VALUES (3, '2024-08-15', 1500.00, 'Bank Transfer');
INSERT INTO payments (booking_id, payment_date, amount, payment_method) VALUES (4, '2024-07-10', 2000.00, 'Credit Card');
INSERT INTO payments (booking_id, payment_date, amount, payment_method) VALUES (2, '2024-09-25', 500.00, 'Cash');

-- 10 update statements
UPDATE hotels SET phone = '3059876543' WHERE hotel_id = 1;
UPDATE rooms SET availability_status = FALSE WHERE room_id = 1;
UPDATE bookings SET payment_status = TRUE WHERE booking_id = 1;
UPDATE customers SET email = 'j.doe@example.com' WHERE customer_id = 1;
UPDATE services SET service_price = 20.00 WHERE service_id = 1;
UPDATE payments SET amount = 620.00 WHERE payment_id = 1;
UPDATE bookings SET total_price = 620.00 WHERE booking_id = 1;
UPDATE rooms SET price_per_night = 130.00 WHERE room_id = 1;
UPDATE hotels SET city = 'Fort Lauderdale' WHERE hotel_id = 1;
UPDATE customers SET phone = '9876543210' WHERE customer_id = 1;

-- 10 deletion statements
DELETE FROM booking_services WHERE booking_id = 1 AND service_id = 1;
DELETE FROM payments WHERE payment_id = 1;
DELETE FROM bookings WHERE booking_id = 1;
DELETE FROM rooms WHERE room_id = 1;
DELETE FROM customers WHERE customer_id = 1;
DELETE FROM services WHERE service_id = 1;
DELETE FROM hotels WHERE hotel_id = 1;
DELETE FROM room_types WHERE room_type_id = 1;
DELETE FROM booking_services WHERE booking_id = 1;
DELETE FROM payments WHERE payment_id = 2;

-- 5 alter table
ALTER TABLE customers ADD COLUMN date_of_birth DATE;
ALTER TABLE rooms ADD COLUMN floor INT;
ALTER TABLE hotels ADD COLUMN star_rating INT DEFAULT 3;
ALTER TABLE payments ADD COLUMN currency VARCHAR(10) DEFAULT 'USD';
ALTER TABLE services ADD COLUMN description VARCHAR(255);

-- Big join statement to join all tables
SELECT 
    h.hotel_name, 
    r.room_number, 
    rt.room_type_name, 
    c.first_name, 
    c.last_name, 
    b.booking_date, 
    b.check_in_date, 
    b.check_out_date, 
    b.total_price, 
    p.amount AS payment_amount, 
    s.service_name
FROM hotels h
LEFT JOIN rooms r ON h.hotel_id = r.hotel_id
LEFT JOIN room_types rt ON r.room_type_id = rt.room_type_id
LEFT JOIN bookings b ON r.room_id = b.room_id
LEFT JOIN customers c ON b.customer_id = c.customer_id
LEFT JOIN payments p ON b.booking_id = p.booking_id
LEFT JOIN booking_services bs ON b.booking_id = bs.booking_id
LEFT JOIN services s ON bs.service_id = s.service_id;

-- 5 statements with LEFT, RIGHT, INNER, OUTER joins
-- Left Join: List all hotels with their rooms (even if a hotel has no rooms yet).
SELECT h.hotel_name, r.room_number
FROM hotels h
LEFT JOIN rooms r ON h.hotel_id = r.hotel_id;

-- Right Join: List all customers and their bookings (even if the customer hasn’t made a booking).
SELECT c.first_name, c.last_name, b.booking_date
FROM customers c
RIGHT JOIN bookings b ON c.customer_id = b.customer_id;

-- Inner Join: List all bookings with their associated customers and payments.
SELECT b.booking_id, c.first_name, c.last_name, p.amount
FROM bookings b
INNER JOIN customers c ON b.customer_id = c.customer_id
INNER JOIN payments p ON b.booking_id = p.booking_id;

-- Full Outer Join: List all customers and their bookings, including customers without bookings and bookings without customer data.
SELECT c.first_name, b.booking_date
FROM customers c
LEFT JOIN bookings b ON c.customer_id = b.customer_id
UNION
SELECT c.first_name, b.booking_date
FROM bookings b
RIGHT JOIN customers c ON b.customer_id = c.customer_id;

-- Left Join: List all services associated with bookings (even if no bookings use services).
SELECT s.service_name, b.booking_id
FROM services s
LEFT JOIN booking_services bs ON s.service_id = bs.service_id
LEFT JOIN bookings b ON bs.booking_id = b.booking_id;

-- 7 statements with aggregate functions and group by (without HAVING)
SELECT hotel_id, COUNT(*) AS room_count 
FROM rooms 
GROUP BY hotel_id;

SELECT customer_id, COUNT(*) AS booking_count 
FROM bookings 
GROUP BY customer_id;

SELECT service_id, SUM(service_price) AS total_revenue 
FROM services 
GROUP BY service_id;

SELECT payment_method, AVG(amount) AS avg_payment 
FROM payments 
GROUP BY payment_method;

SELECT room_type_id, MIN(price_per_night) AS min_price 
FROM rooms 
GROUP BY room_type_id;

SELECT hotel_id, MAX(star_rating) AS highest_rating 
FROM hotels 
GROUP BY hotel_id;

SELECT city, COUNT(*) AS hotel_count 
FROM hotels 
GROUP BY city;

-- 7 statements with aggregate functions and group by (with HAVING)
SELECT hotel_id, COUNT(*) AS room_count 
FROM rooms 
GROUP BY hotel_id 
HAVING room_count > 1;

SELECT customer_id, COUNT(*) AS booking_count 
FROM bookings 
GROUP BY customer_id 
HAVING booking_count > 1;

SELECT service_id, SUM(service_price) AS total_revenue 
FROM services 
GROUP BY service_id 
HAVING total_revenue > 100;

SELECT payment_method, AVG(amount) AS avg_payment 
FROM payments 
GROUP BY payment_method 
HAVING avg_payment > 1000;

SELECT room_type_id, MIN(price_per_night) AS min_price 
FROM rooms 
GROUP BY room_type_id 
HAVING min_price > 100;

SELECT hotel_id, MAX(star_rating) AS highest_rating 
FROM hotels 
GROUP BY hotel_id 
HAVING highest_rating >= 3;

SELECT city, COUNT(*) AS hotel_count 
FROM hotels 
GROUP BY city 
HAVING hotel_count > 1;