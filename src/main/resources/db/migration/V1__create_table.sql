-- cvbuilder_schema
CREATE SCHEMA IF NOT EXISTS cvbuilder_schema;

-- user
CREATE TABLE IF NOT EXISTS cvbuilder_schema.users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- pdf_files
CREATE TABLE IF NOT EXISTS cvbuilder_schema.pdf_files (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES cvbuilder_schema.users(id) ON DELETE CASCADE,
    file_path TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);