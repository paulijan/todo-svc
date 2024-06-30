# To-Do Service Backend

## Übersicht

Dies ist das Backend für die To-Do Listen-Anwendung. Es handelt sich um eine RESTful API, die mit Spring Boot entwickelt wurde. Die API ermöglicht es, To-Do Aufgaben zu erstellen, zu lesen, zu aktualisieren und zu löschen (CRUD-Operationen).

## Voraussetzungen

- Java 17
- Gradle 7.x
- PostgreSQL (für Produktionsdatenbank)
- H2 (für Tests)

## Installation

1. **Repository klonen**:
   ```bash
   git clone https://github.com/username/todo-svc.git
   cd todo-svc
   
2. **Abhängigkeiten installieren**: 
   ```bash
   ./gradlew clean build

## Konfiguration

**Anwendungskonfiguration**

Die Anwendungskonfiguration erfolgt über die application.yml Datei im Verzeichnis src/main/resources



**Testkonfiguration**

Die Testkonfiguration erfolgt über die application-test.yml Datei im Verzeichnis src/test/resources



## Ausführen der Anwendung

**Lokale Entwicklung**

Starten Sie die Anwendung mit dem folgenden Befehl

./gradlew bootRun


## API Endpunkte 

**To-Do API**


- GET /api/v1/todos - Alle To-Dos abrufen
- GET /api/v1/todos/{id} - To-Do nach ID abrufen
- POST /api/v1/todos - Neues To-Do erstellen
- PUT /api/v1/todos/{id} - To-Do aktualisieren
- DELETE /api/v1/todos/{id} - To-Do löschen