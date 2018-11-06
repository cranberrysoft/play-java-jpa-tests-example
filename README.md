# play-java-jpa-tests-example

This project demonstrates how to create a simple model tests with Play 2.6, Evolutions and JPA. I used [GitHub](https://github.com/playframework/play-java-jpa-example) project as a reference.

## Usage

+ Create evolutions for the test evolutions/db1/1.sql
```sql
# --- !Ups

INSERT INTO Person VALUES (1, 'Mariusz')
```

+ Implement test
```java
public class MyDbTest extends TestServerBase {
 
     @Override
     public String dbName() {
         return "db1";
     }
 
     @Test
     public void sometest() {
         //implement test
     }
 
 }
 ```

## Running tests
```bash
sbt test
```

---
### Credits
*Mariusz Dubielecki* [cranberrysoft.com](http://cranberrysoft.com) 
