-- ==========================================
-- 1. SETUP DATABASE (Fixes 'No database selected')
-- ==========================================
DROP DATABASE IF EXISTS tapir_db;  -- WARNING: Deletes old data to start fresh
CREATE DATABASE tapir_db;
USE tapir_db;                      -- <--- THIS FIXES YOUR ERROR

-- ==========================================
-- 2. HUMAN RESOURCES (Users & Employees)
-- ==========================================

-- Table 1: Users (Must be first, no dependencies)
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       user_name VARCHAR(50) NOT NULL UNIQUE,
                       user_password VARCHAR(255) NOT NULL,
                       user_role VARCHAR(20) NOT NULL       -- 'SUPERADMIN', 'ADMIN', 'STAFF'
);

-- Table 2: Employees (Links to User)
CREATE TABLE employees (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           user_id BIGINT UNIQUE,               -- Link to Login

                           name VARCHAR(100) NOT NULL,
                           ic_no VARCHAR(20) UNIQUE,
                           gender VARCHAR(10),
                           birth_date DATE,
                           phone_no VARCHAR(20),
                           home_address TEXT,

                           job_title VARCHAR(50),
                           department VARCHAR(50),
                           work_address TEXT,
                           salary DECIMAL(10, 2),
                           status VARCHAR(20),                  -- 'ACTIVE', 'TERMINATED'
                           join_date DATE,

                           emergency_contact_name VARCHAR(100),
                           emergency_phone_no VARCHAR(20),
                           health_condition TEXT,

                           FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Table 3: Complaints (Links to Employee)
CREATE TABLE complaints (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            employee_id BIGINT,                  -- Who is this about?

                            subject VARCHAR(100),
                            description TEXT,
                            incident_date DATETIME,
                            reported_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                            severity VARCHAR(20),
                            status VARCHAR(20),

                            complainant_name VARCHAR(100),
                            complainant_email VARCHAR(100),
                            complainant_phone_no VARCHAR(20),
                            evidence_url VARCHAR(255),
                            resolution_notes TEXT,

                            FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);

-- ==========================================
-- 3. TRANSIT NETWORK (Ops, Lines, Stops)
-- ==========================================

-- Table 4: Operators (The Companies)
CREATE TABLE operators (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           co_reg_no VARCHAR(50),
                           contact_email VARCHAR(100),
                           contact_no VARCHAR(20),
                           hq_address TEXT,
                           license_code VARCHAR(50),
                           status VARCHAR(20) DEFAULT 'ACTIVE'
);

-- Table 5: Transits (The Systems)
CREATE TABLE transits (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          operator_id BIGINT,
                          manager_id BIGINT,

                          name VARCHAR(100) NOT NULL,
                          type VARCHAR(50),                    -- 'METRO', 'LRT'
                          region VARCHAR(50),
                          website_url VARCHAR(255),
                          logo_url VARCHAR(255),
                          status VARCHAR(20) DEFAULT 'ACTIVE',

                          FOREIGN KEY (operator_id) REFERENCES operators(id) ON DELETE SET NULL,
                          FOREIGN KEY (manager_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Table 6: Lines (Using backticks `lines` to avoid syntax error)
CREATE TABLE `lines` (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         operator_id BIGINT,
                         transit_id BIGINT,

                         name VARCHAR(100) NOT NULL,
                         code VARCHAR(10),
                         colour_hex VARCHAR(10),
                         length_km DOUBLE,
                         date_started DATE,
                         status VARCHAR(20),

                         FOREIGN KEY (operator_id) REFERENCES operators(id) ON DELETE SET NULL,
                         FOREIGN KEY (transit_id) REFERENCES transits(id) ON DELETE SET NULL
);

-- Table 7: Stops (Physical Locations)
CREATE TABLE stops (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       latitude DOUBLE,
                       longitude DOUBLE,
                       type VARCHAR(20),
                       is_interchange BOOLEAN,
                       is_have_park_and_ride BOOLEAN,
                       date_started DATE
);

-- Table 8: Route Stops (The Sequence)
CREATE TABLE route_stops (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             line_id BIGINT NOT NULL,
                             stop_id BIGINT NOT NULL,

                             station_code VARCHAR(10),
                             sequence_number INT,

                             FOREIGN KEY (line_id) REFERENCES `lines`(id) ON DELETE CASCADE,
                             FOREIGN KEY (stop_id) REFERENCES stops(id) ON DELETE CASCADE
);

-- ==========================================
-- 4. ASSETS & INCIDENTS
-- ==========================================

-- Table 9: Vehicles
CREATE TABLE vehicles (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          code VARCHAR(20) NOT NULL UNIQUE,
                          type VARCHAR(20),
                          colour VARCHAR(20),
                          status VARCHAR(20) DEFAULT 'ACTIVE',
                          malfunction_details TEXT,

                          current_driver_id BIGINT,
                          current_line_id BIGINT,

                          FOREIGN KEY (current_driver_id) REFERENCES employees(id) ON DELETE SET NULL,
                          FOREIGN KEY (current_line_id) REFERENCES `lines`(id) ON DELETE SET NULL
);

-- Table 10: Vehicle Breakdowns
CREATE TABLE vehicle_breakdowns (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    vehicle_id BIGINT NOT NULL,
                                    breakdown_manager_id BIGINT,

                                    timestamp DATETIME NOT NULL,
                                    reason VARCHAR(255),
                                    description TEXT,
                                    status VARCHAR(20),
                                    duration_minutes INT,

                                    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE,
                                    FOREIGN KEY (breakdown_manager_id) REFERENCES employees(id) ON DELETE SET NULL
);

-- Table 11: Fact Line Breakdowns (Infrastructure)
CREATE TABLE fact_line_breakdowns (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      line_id BIGINT NOT NULL,
                                      breakdown_manager_id BIGINT,

                                      timestamp DATETIME NOT NULL,
                                      reason VARCHAR(255),
                                      description TEXT,
                                      status VARCHAR(20),
                                      duration_minutes INT,

                                      FOREIGN KEY (line_id) REFERENCES `lines`(id) ON DELETE CASCADE,
                                      FOREIGN KEY (breakdown_manager_id) REFERENCES employees(id) ON DELETE SET NULL
);

-- ==========================================
-- 5. ANALYTICS (Fact Tables)
-- ==========================================

-- Table 12: Daily Ridership
CREATE TABLE fact_line_daily_ridership (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           record_date DATE NOT NULL,
                                           line_id BIGINT NOT NULL,

                                           total_riders INT,
                                           peak_hour_riders INT,

                                           FOREIGN KEY (line_id) REFERENCES `lines`(id) ON DELETE CASCADE
);

-- Table 13: Station Traffic
CREATE TABLE fact_stops_traffic_daily (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          record_date DATE NOT NULL,
                                          stop_id BIGINT NOT NULL,

                                          entries_count INT,
                                          exits_count INT,

                                          FOREIGN KEY (stop_id) REFERENCES stops(id) ON DELETE CASCADE
);