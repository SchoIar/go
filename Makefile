run: setup_db
	mvn clean compile exec:java

test:
	mvn test

clean:
	mvn clean
	rm -rf database/puzzles.db

build:
	mvn clean package

build_and_run: build
	java -jar target/gopuzzles-1.0-SNAPSHOT.jar

setup_db:
	python3 database/setup.py