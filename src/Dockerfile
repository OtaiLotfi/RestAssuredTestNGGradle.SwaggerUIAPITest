# Use a Maven image to build the project and run tests
FROM maven:3.8.1-openjdk-11

# Set the working directory in the container
WORKDIR /app

# Copy your project files into the container
COPY . .

# Install any required dependencies and build the project
RUN mvn clean install -DskipTests

# Run your API tests using TestNG and the testng.xml file
CMD ["mvn", "test", "-DsuiteXmlFile=src/test/java/test/petStoreTests/testng.xml"]
