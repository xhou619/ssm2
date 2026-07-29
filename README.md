# SSM2 — Spring Boot + MyBatis Demo

A Spring Boot 4 demonstration project showcasing **MyBatis** as the persistence layer with MySQL, featuring one-to-one and one-to-many association mappings.

## Tech Stack

| Technology | Version |
|------------|---------|
| Java | 17 |
| Spring Boot | 4.0.7 |
| MyBatis Spring Boot Starter | 4.0.1 |
| MySQL | 8.0+ (LTS) |
| Lombok | (latest) |
| Docker Compose | (for local MySQL) |

## Features

- **One-to-One Association** — `Student` → `StudentID` mapped via MyBatis `<association>`, demonstrated with two strategies:
  - **Nested Select** (`/v1/students/{id}`) — fires a separate query for the associated `StudentID`.
  - **Single JOIN** (`/v2/students/{id}`) — loads everything in one query using a multi-table join.
- **One-to-Many Collection** — `Class` → `List<Student>` mapped via MyBatis `<collection>`, returning all students belonging to a class in a single query.
- **RESTful API** — Clean, versioned endpoints returning JSON responses.
- **Database Initialization** — Auto-creates schema and seeds sample data on startup via `schema.sql` and `data.sql`.
- **Docker Compose** — One-command MySQL setup for local development.

## Domain Model

```
┌──────────────┐       ┌──────────────┐       ┌──────────────┐
│   StudentID  │       │   Student    │       │    Class     │
├──────────────┤       ├──────────────┤       ├──────────────┤
│ id: Integer  │◄──────│ id: Integer  │       │ id: Integer  │
│ code: String │       │ name: String │──┬───►│ name: String │
└──────────────┘       │ sex: char    │  │    │ students:    │
                       │ sid: StudentID│  │    │   List<Student>│
                       │ cid: Integer │──┘    └──────────────┘
                       └──────────────┘
```

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| `GET` | `/v1/students/{id}` | Get a student by ID (nested-select mapping) |
| `GET` | `/v2/students/{id}` | Get a student by ID (single-JOIN mapping) |
| `GET` | `/v1/classes/{cid}` | Get all students in a class (one-to-many collection) |

### Example Response

`GET /v1/students/1`

```json
{
  "id": 1,
  "name": "john",
  "sex": "f",
  "sid": {
    "id": 1,
    "code": "18030128"
  }
}
```

`GET /v1/classes/1`

```json
[
  {
    "id": 1,
    "name": "john",
    "sex": "f",
    "sid": { "id": 1, "code": "18030128" }
  },
  {
    "id": 2,
    "name": "jack",
    "sex": "m",
    "sid": { "id": 2, "code": "18030135" }
  }
]
```

## Getting Started

### Prerequisites

- JDK 17+
- Docker & Docker Compose
- Maven (wrapper included — `mvnw`)

### 1. Start MySQL

```bash
docker compose up -d
```

This spins up a MySQL container with:
- Database: `db_mybatis`
- User: `breeze` / `!P@ssword`
- Port: `3306`

### 2. Run the Application

```bash
./mvnw spring-boot:run
```

On first launch, `schema.sql` and `data.sql` initialize the tables and seed sample data.

### 3. Test the API

```bash
curl http://localhost:8080/v1/students/1
curl http://localhost:8080/v2/students/1
curl http://localhost:8080/v1/classes/1
```

## Project Structure

```
SSM2/
├── docker-compose.yml              # MySQL container setup
├── pom.xml                         # Maven dependencies
├── src/
│   ├── main/
│   │   ├── java/com/example/ssm2/
│   │   │   ├── Ssm2Application.java          # Spring Boot entry point
│   │   │   ├── controller/
│   │   │   │   ├── StudentController.java     # GET /v1/students/{id}
│   │   │   │   ├── StudentControllerV2.java   # GET /v2/students/{id}
│   │   │   │   └── ClassController.java       # GET /v1/classes/{cid}
│   │   │   ├── mapper/
│   │   │   │   ├── StudentMapper.java         # Student queries interface
│   │   │   │   ├── StudentIDMapper.java       # StudentID query interface
│   │   │   │   └── ClassMapper.java           # Class query interface
│   │   │   ├── po/
│   │   │   │   ├── Student.java               # Student entity
│   │   │   │   ├── StudentID.java             # StudentID entity
│   │   │   │   └── Class.java                 # Class entity
│   │   │   └── service/
│   │   │       ├── StudentService.java        # Student business logic
│   │   │       └── ClassService.java          # Class business logic
│   │   └── resources/
│   │       ├── application.yaml               # App & DB configuration
│   │       ├── schema.sql                     # DDL (auto-run on startup)
│   │       ├── data.sql                       # Seed data (auto-run on startup)
│   │       └── mapper/
│   │           ├── StudentMapper.xml           # MyBatis XML mappings
│   │           ├── StudentIDMapper.xml
│   │           └── ClassMapper.xml
│   └── test/
│       └── java/com/example/ssm2/
│           └── Ssm2ApplicationTests.java      # Spring Boot test
└── .mvn/wrapper/                              # Maven wrapper scripts
```

## MyBatis Mapping Highlights

### Nested Select vs. Single JOIN

The project demonstrates two ways to map a one-to-one association:

**V1 — Nested Select** (`findStudentById`):
```xml
<association property="sid" column="sid" javaType="...StudentID"
             select="...StudentIDMapper.findCodeById"/>
```
Two queries fire: first for the student, then for the associated `StudentID`.

**V2 — Single JOIN** (`findStudentById2`):
```xml
<association property="sid" javaType="...StudentID">
    <id property="id" column="id"/>
    <result property="code" column="code"/>
</association>
```
One query with a multi-table join — better for performance when you always need the association.

### One-to-Many Collection

```xml
<collection property="students" ofType="...Student">
    <!-- maps Student fields including nested sid association -->
</collection>
```

## License

This project is for educational/demonstration purposes.
