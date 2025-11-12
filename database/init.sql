-- SQL script to create tables (also executed automatically by DBUtil)
CREATE TABLE IF NOT EXISTS users (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  username TEXT UNIQUE NOT NULL,
  password TEXT NOT NULL,
  role TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  code TEXT UNIQUE,
  name TEXT,
  category TEXT,
  price REAL,
  stock INTEGER,
  description TEXT,
  image_path TEXT
);

CREATE TABLE IF NOT EXISTS ventas (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  cliente TEXT,
  fecha TEXT,
  vendedor TEXT,
  total REAL,
  impreso INTEGER DEFAULT 0,
  impresora TEXT
);

CREATE TABLE IF NOT EXISTS detalle_ventas (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  venta_id INTEGER,
  product_id INTEGER,
  cantidad INTEGER,
  precio_unit REAL,
  subtotal REAL,
  FOREIGN KEY(venta_id) REFERENCES ventas(id),
  FOREIGN KEY(product_id) REFERENCES products(id)
);
