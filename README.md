# Complaint Management System (Spring Boot)

## Overview

This is a backend project built using Spring Boot where users can create complaints and track their status.

---

## Features

* User creation and retrieval
* Complaint creation
* Status update (OPEN → IN_PROGRESS → RESOLVED)
* Validation of input data
* Global exception handling
* Pagination and filtering
* Clean API responses using DTO

---

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## API Endpoints

### User APIs

* POST `/api/users`
* GET `/api/users`
* GET `/api/users/{id}`

---

### Complaint APIs

* POST `/api/complaints/{userId}`
* GET `/api/complaints`
* GET `/api/complaints/{id}`

---

### Status Update

* PUT `/api/complaints/{id}/status?status=IN_PROGRESS`

---

### Filtering & Pagination

* `/api/complaints?status=OPEN`
* `/api/complaints?page=0&size=5`
* `/api/complaints?status=OPEN&page=0&size=5`

---

## 📂Postman Collection

All APIs are tested and available here:

`postman/complaint-system-collection.json`

---

## Learning Outcome

Learned how to build structured backend systems using Spring Boot with proper architecture and validation.
