INSERT INTO Incident_Types(Incident_Type_Id, Type, Expected_SLA_In_Days) VALUES
(20001, 'Driver Misconduct', 3),
(20002, 'Vehicle Issue', 2),
(20003, 'Payment/Billing Problem', 5),
(20004, 'Safety Concern', 1),
(20005, 'Ride Cancellation Issue', 3),
(20006, 'App/Technical Glitch', 4),
(20007, 'Lost Item', 2),
(20008, 'Delay in Pickup', 2),
(20009, 'Wrong Route Taken', 3),
(20010, 'Poor Vehicle Cleanliness', 3),
(20011, 'Driver No-Show', 2),
(20012, 'Inaccurate ETA', 4),
(20013, 'Trip Not Logged in History', 5),
(20014, 'Multiple Driver Assignments', 4),
(20015, 'Fare Estimate Mismatch', 5),
(20016, 'Minor Accident (No Injuries)', 2),
(20017, 'Major Accident (Injuries Reported)', 1),
(20018, 'Collision With Another Vehicle', 2),
(20019, 'Collision With Pedestrian/Object', 1),
(20020, 'Sudden Braking or Swerving', 2),
(20021, 'Airbag Deployment', 1),
(20022, 'Hit and Run (Driver Fled Scene)', 1),
(20023, 'Medical Emergency During Ride', 1),
(20024, 'Accident Due to Poor Vehicle Condition', 2),
(20025, 'Accident Involving a Third Party Driver', 2);

INSERT INTO Incidents (
  Incident_Id, Incident_Date, Report_Date, Resolution_ETA,
  Investigated_By_User_Id, Incident_Details, Booking_Id,
  Status, Incident_Type_Id
) VALUES
('2025-4989', '2025-05-24', '2025-05-24', '2025-05-27', 8987, 'Driver was continuously on the phone during the ride, making the rider uncomfortable.', 7011, 'CLOSED', 20001),
('2025-4979', '2025-05-23', '2025-05-24', '2025-05-26', 980, 'The car engine overheated during the ride, and the trip was halted midway.', 7012, 'CLOSED', 20002),
('2025-5350', '2025-05-22', '2025-05-24', '2025-05-29', 6016, 'User was charged surge pricing despite booking well in advance.', 7013, 'PENDING', 20003),
('2025-1339', '2025-05-23', '2025-05-24', '2025-05-27', 5443, 'Ride was cancelled 2 minutes before scheduled pickup time by the driver.', 7015, 'CLOSED', 20005),
('2025-4117', '2025-05-22', '2025-05-24', '2025-05-28', 0, 'The app froze after booking was confirmed, and trip details disappeared.', 7016, 'PENDING', 20006),
('2025-7505', '2025-05-24', '2025-05-24', '2025-05-26', 0, 'Rider left a phone in the vehicle and could not contact the driver afterward.', 7017, 'PENDING', 20007),
('2025-3847', '2025-05-23', '2025-05-24', '2025-05-26', 0, 'Driver arrived 20 minutes late without prior notice.', 7018, 'PENDING', 20008),
('2025-9739', '2025-05-22', '2025-05-24', '2025-05-27', 0, 'Driver took a completely different and longer route than estimated.', 7019, 'PENDING', 20009),
('2025-7207', '2025-05-24', '2025-05-24', '2025-05-26', 0, 'There was a minor collision at a traffic signal, but no injuries occurred.', 7020, 'PENDING', 20016);

INSERT INTO Investigation_Details (
  Findings, Suggestions, Investigation_Date, Investigation_Result, Incident_Id
) VALUES
(
  'Driver admitted to phone use during the trip, which is against company policy.',
  'Issue a formal warning and schedule driver safety training.',
  '2025-05-24',
  'RESOLVED',
  '2025-4989'
),
(
  'Vehicle inspection confirmed engine overheating due to lack of coolant maintenance.',
  'Require immediate vehicle service and delay reactivation until fixed.',
  '2025-05-24',
  'RESOLVED',
  '2025-4979'
),
(
  'Billing system logs showed surge pricing correctly applied; customer misunderstanding confirmed.',
  'Improve surge pricing notifications in the app and update FAQs.',
  '2025-05-24',
  'UN_RESOLVED',
  '2025-5350'
),
(
  'Driver cancelled ride without notification due to personal emergency; no system alert triggered.',
  'Implement auto-notifications for cancellations and train drivers on communication protocols.',
  '2025-05-24',
  'RESOLVED',
  '2025-1339'
);

insert into Users(user_name, password, role) values
('user123', '12345', 'user'),
('admin123', '12345', 'admin');