# PostInflux Enterprise Dispatch Console

## Application Deployment Node
The live web instance has been containerized and deployed to cloud hosting at the production link: https://postinflux.azurewebsites.net

---

## Problem & Solution Scope

### Project Problem Statement
Traditional e-commerce environments often decouple transaction notifications from design workflows, resulting in plain, unengaging text alerts that harm merchant branding. Small-scale digital merchants frequently lack the budget or technical infrastructure to deploy custom-branded delivery emails, while setting up professional enterprise relays requires dealing with complex third-party system configurations.

### Core Solution Architecture
PostInflux addresses this engineering bottleneck by introducing a full-stack automated dispatch workspace. Built entirely upon a lightweight, high-performance local state synchronization model, the platform embeds user-friendly inventory assets and customer books straight into an asynchronous mail routing engine. The system programmatically wraps custom message narratives inside immersive, responsive background layouts before dispatching them over secure transport sockets.

---

## Workspace Directory Structure & File Mappings

The organization of files within the workstation directory path `C:\project\post_influx\` and their specific roles inside the application architecture are detailed below:

| System File / Folder Path | Architecture Component Identity | Code Function & Purpose |
| :--- | :--- | :--- |
| `src/main/java/.../controller/MailController.java` | REST Endpoint API Controller | Captures incoming multi-part form data requests and feeds transaction attributes to the mail service layer. |
| `src/main/java/.../controller/ViewController.java` | MVC UI Routing Controller | Intercepts HTTP browser requests and serves compiled web dashboard template pages to the client. |
| `src/main/java/.../model/CampaignLog.java` | Database Entity Model | Maps database row properties tracking historical email dispatch definitions, metadata, and status tokens. |
| `src/main/java/.../model/User.java` | Security Entity Model | Validates merchant profile login identities during the workspace registration stage. |
| `src/main/java/.../repository/CampaignLogRepository.java` | Database Data Access Layer | Spring Data repository interface managing automated SQL queries to pull and append delivery log histories. |
| `src/main/java/.../repository/UserRepository.java` | Database Data Access Layer | Spring Data repository interface managing database persistence queries for active merchant user profiles. |
| `src/main/java/.../service/EmailService.java` | Business Logic Core Engine | Assembles the underlying MIME message structures, injects structural HTML scenery layouts, and appends files. |
| `src/main/java/.../PostInfluxApplication.java` | Core Spring Boot Runtime | Serves as the master entry point class containing the main method to boot the integrated Tomcat container. |
| `src/main/resources/templates/index.html` | Frontend Landing View | The initial interactive user login and brand setup authentication dashboard gateway interface. |
| `src/main/resources/templates/dashboard.html` | Frontend Master Workspace | The central center-aligned UI managing send utility forms, interactive inventory grids, and live diagnostics. |
| `src/main/resources/templates/track-order.html` | Frontend Verification Portal | A customer-facing receipt checking frame allowing buyers to verify delivery status parameter logs. |
| `src/main/resources/application.properties` | Environment Configurations | Houses environment settings including H2 data-source parameters, JPA settings, and secure SMTP relay rules. |
| `Dockerfile` | Cloud Containerization Blueprint | Contains the step-by-step instructions needed to wrap the target executable application into a Docker image. |
| `pom.xml` | Maven Dependency Matrix | Coordinates external open-source library definitions, compiler build levels, and Azure deployment targets. |

---

## Core Features

### Interactive Send Mail Utility
A streamlined, central dashboard form with transparent input fields where merchants can manually tweak email tracking masks, subjects, dynamic banner headings, text narratives, and binary file attachments.

### Live Catalog & Directory Coupling
A high-fidelity inventory and contact management workspace. Clicking a product asset or a registered customer immediately injects their respective data records, themes, and pre-configured body narratives straight into the mail launcher form.

### Dynamic Scenery Backdrop Layouts
The engine parses a theme variable selection to automatically generate and send a premium HTML framework email featuring beautiful visual backdrops including the Emerald Northern Lights, Serene Sunset Mountain Range, or Tranquil Deep Ocean Horizon.

### Performance Core Monitor
An interactive infrastructure socket checker that emulates low-level system connections to outbound gateway targets like Google Auth Relay. It tracks certificate handshakes, logs raw terminal outputs, and reports live server routing latency times.

### Global Distribution Hub Mapping
An interactive server routing panel allowing users to manually toggle active cloud channels between regional routing hubs, automatically mapping underlying from-address variables.

### Live Session Audit Ledger
A real-time transactional table tracking every successfully deployed transmission package during the session, logging the exact origin node, target account, subject, timestamp, and status.

---

## Technology Stack

### Backend Infrastructure Engine
Java 17 runtime environment coupled with the Spring Boot 3.3.0 framework. Outbound communication channels utilize the spring-boot-starter-mail relay layer alongside JavaMailSender to execute low-level SMTP handshakes over authenticated TLS/SSL networks.

### Persistence Cache Layer
Local application state, delivery transactions, and system audit logs are managed using an embedded H2 database engine running in-memory. Database schema mappings and object-relational queries are handled smoothly by Spring Data JPA.

### Frontend Presentation Layer
The client interface is built using standard HTML5 and responsive CSS3, heavily featuring premium modern glassmorphism, translucent bubble design accents, and center-aligned workspace grids. Dynamic layout updates, preset form property injections, and automated performance logs are driven by a native, lightweight JavaScript ES6 engine working hand-in-hand with the Thymeleaf template compilation loop.

### Cloud Deployment Profile
Production hosting is powered by Microsoft Azure App Service. The application is packaged into an executable binary and deployed to a stable Linux runtime web container to handle real-time internet traffic safely.

---

## Prerequisites

Before setting up and running the application locally, ensure you have the following components installed on your development workstation:
* Java Development Kit (JDK) 17 or higher
* Apache Maven 3.x (or use the included wrapper script `mvnw`)
* A modern web browser (Google Chrome, Microsoft Edge, Mozilla Firefox)
* A valid SMTP configuration (e.g., an email account with an App Password configured if using Gmail)

---

## Installation & Local Execution Steps

Follow these steps to configure, build, and run the application locally on your machine:

### 1. Navigate to Project Workspace
Open your terminal or PowerShell command line tool and ensure you are situated inside your project directory root:
```cmd
    cd C:\project\post_influx
```

### 2. Configure Credentials
Open the `src/main/resources/application.properties` file and supply your active mail server connection variables:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@domain.com
spring.mail.password=your-secure-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 3. Compile and Package the Binary
Run the local Maven wrapper script to compile your backend files and package your frontend assets into a clean, deployable executable `.jar` file while bypassing unit testing frameworks:

```cmd
.\mvnw package "-Dmaven.test.skip=true"
```

### 4. Run the Application
Execute the compiled Spring Boot application archive using the Java virtual machine runner:
```
java -jar target/post_influx-0.0.1-SNAPSHOT.jar
```
Alternatively, you can boot the runtime development environment directly using the Maven plugin goal:
```
.\mvnw spring-boot:run
```
### 5. Access the Local Interface
Once your console terminal logs show that the embedded Tomcat container has successfully initialized on port 8080, open your web browser and navigate to the local portal link:
```
http://localhost:8080
```