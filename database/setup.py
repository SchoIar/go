import sqlite3
import os

db_dir = os.path.dirname(os.path.abspath(__file__))

db = "puzzles.db"
db_path = os.path.join(db_dir, db)
schema_path = os.path.join(db_dir, "schema.sql")
insert_path = os.path.join(db_dir, "puzzles.sql")

if os.path.exists(db_path):
    print(f"{db} already exists.")
else:
    with open(schema_path, "r") as f:
        schema_sql = f.read()

    with open(insert_path, "r") as f:
        insert_sql = f.read()

    conn = sqlite3.connect(db_path)
    cursor = conn.cursor()

    cursor.executescript(schema_sql)
    cursor.executescript(insert_sql)

    conn.commit()
    conn.close()
    print(f"{db} created and populated")
