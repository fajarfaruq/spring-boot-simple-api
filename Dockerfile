From openjdk:18.0
ADD ./target/*.jar simpleapi.jar 
ENTRYPOINT ["java", "-jar" , "simpleapi.jar"]