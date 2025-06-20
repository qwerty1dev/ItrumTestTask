# ItrumTestTask

Build the JAR file:
mvn clean package -DskipTests

Run without docker
java -DDB_HOST=localhost -DDB_PORT=5432 -DDB_NAME=wallets -DDB_USER=your_db_user -DDB_PASSWORD=your_db_password -jar target\wallet-service-1.0.0.jar

Run with Docker
docker-compose up --build -d
