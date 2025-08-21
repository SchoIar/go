run:
	mvn clean compile exec:java

test:
	mvn test

clean:
	mvn clean
	rm -rf database/puzzles.db

setup_db:
	python3 database/setup.py