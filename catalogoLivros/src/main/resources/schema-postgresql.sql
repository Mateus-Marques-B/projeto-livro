CREATE TABLE IF NOT EXISTS livro (
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(80) NOT NULL,
  autor VARCHAR(60) NOT NULL,
  genero VARCHAR(60),
  ano INT
);