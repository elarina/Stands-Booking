Web application for monitoring the status of stands

# Run application on Windows

Configure and run application

## Common Prerequisites

Postgree SQL - https://www.postgresql.org/download/

### Installation

1. Download and run Postgree SQL installer.
2. Choose install directory, which path does not contain spaces.
3. Choose all components for installation (PostgreSQL Server, pgAdmin 4, Stack Builder, Command Line Tools)
4. Choose data directory, which path does not contain spaces.
5. Enter password "12345" for superuser (postgres)
6. Enter port 5432.
7. Select Russian locale.
8. Install.

### Configuration

1. Enter win+R and enter "services.msc"
2. In opened window find postresql-...-...
3. Right click on postgresql-...-... and Run

### View data in DB

1. Open SQL Shell (psql)
2. Enter default server name, database, port, username and password 12345.
3. Enter query and view result.

## Run from IDE

Configure and run application from Eclipse IDE

### Prerequisites for run application from IDE

Eclipse IDE - https://www.eclipse.org/downloads/

#### Installation

1. Download and run Eclipse installer.
2. In installation menu choose "Eclipse IDE for Enterprise Java and Web Developers".
3. Choose JRE 21.0.5 and define installation folder.
4. Click Install.


### Import to workspace

1. Run in command line: git clone https://github.com/elarina/Stand_State.git Stands_State
2. Run installed Eclipse IDE.
3. File -> Import -> Maven -> Existing Maven Projects
4. Select root directory of cloned project: Stands_State 
5. Click Finish.

### Run

1. Open class /stands_state/src/main/java/com/larina/StandsStateApplication.java
2. Enter CTRL+F11
3. Open browser.
4. In address bar enter localhost:8080/stands

# Demo
See demo/stands_state_demo.mp4

# UI on Figma
https://www.figma.com/proto/igwGeY3MepQ3tgyGH0yTDF/Stands_State

# Usefull links
Spring Tools Suite install - https://github.com/spring-projects/spring-tools/wiki/Installation
