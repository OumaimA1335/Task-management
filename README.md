# 📝 Task Management DevOps Project

## 🚀 Project Overview
This project is a **Task Management REST API** developed with a strong focus on **DevOps practices**.  
It includes **observability**, **security testing**, **containerization**, **CI/CD**, and **deployment automation**, demonstrating a complete DevOps workflow.

---

## ✨ Features

- **REST API**: Manage tasks (create, read, update, delete)  
- **API Testing**: ✅ Tested with **Postman**  
- **Observability**:
  - 📊 Metrics: **Micrometer** + **Prometheus**
  - 📝 Logging: **Logback**
  - 🔗 Tracing: **Micrometer Tracing Bridge**
- **Security Testing**:
  - 🛡️ SAST: **SonarCloud**
  - 🕵️ DAST: **OWASP ZAP**
- **Containerization**:
  - 🐳 Dockerized app and MySQL database
  - 🧩 Multi-container management with **Docker Compose**
- **Deployment**:
  - ☸️ Deployed using **KIND (Kubernetes IN Docker)**
- **CI/CD**:
  - ⚙️ Automated with **GitHub Actions**

---

## 🛠️ Tech Stack

- **Backend**: REST API (Java / Spring Boot)  
- **Database**: MySQL (Dockerized)  
- **Containerization**: Docker, Docker Compose  
- **Kubernetes**: KIND  
- **Observability**: Micrometer, Prometheus, Logback  
- **Tracing**: Micrometer Tracing Bridge  
- **Security Testing**: SonarCloud (SAST), OWASP ZAP (DAST)  
- **CI/CD**: GitHub Actions  
- **API Testing**: Postman  

---

## ⚡ Getting Started

### Prerequisites

- Docker & Docker Compose 🐳  
- Java 17+ / Spring Boot ☕  
- Git 🧬  
- KIND (for local Kubernetes deployment) ☸️  
- Prometheus (optional, for metrics) 📊  

### Running Locally

1. Clone the repository:  
   ```bash
   git clone <repo-url>
   cd task-management
2. Start MySQL and the API using Docker Compose:
     ```bash
   docker-compose up --build
