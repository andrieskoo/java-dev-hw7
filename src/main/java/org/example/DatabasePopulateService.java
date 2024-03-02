package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.Utility.*;

public class DatabasePopulateService {
    private  static final Logger loger = LogManager.getLogger(DatabasePopulateService.class);

    public static void main(String[] args) {
        Connection connection = H2Database.getINSTANCE().getConnection();

        populateWorkers(connection);
        populateClients(connection);
        populateProject(connection);
        populateProjectWorker(connection);



    }

    private static void populateProjectWorker(Connection connection) {
        List<ProjectWorker> projectWorkerList = new ArrayList<>();
        projectWorkerList.add(new ProjectWorker(1, 16));
        projectWorkerList.add(new ProjectWorker(1, 3));
        projectWorkerList.add(new ProjectWorker(2, 1));
        projectWorkerList.add(new ProjectWorker(2, 16));
        projectWorkerList.add(new ProjectWorker(3, 3));
        projectWorkerList.add(new ProjectWorker(3, 5));
        projectWorkerList.add(new ProjectWorker(3, 6));
        projectWorkerList.add(new ProjectWorker(3, 7));
        projectWorkerList.add(new ProjectWorker(4, 16));
        projectWorkerList.add(new ProjectWorker(5, 6));
        projectWorkerList.add(new ProjectWorker(5, 16));
        projectWorkerList.add(new ProjectWorker(5, 5));
        projectWorkerList.add(new ProjectWorker(8, 16));
        projectWorkerList.add(new ProjectWorker(8, 15));
        projectWorkerList.add(new ProjectWorker(8, 5));
        projectWorkerList.add(new ProjectWorker(6, 6));
        projectWorkerList.add(new ProjectWorker(7, 1));
        projectWorkerList.add(new ProjectWorker(7, 4));
        projectWorkerList.add(new ProjectWorker(8, 4));
        projectWorkerList.add(new ProjectWorker(8, 7));
        projectWorkerList.add(new ProjectWorker(9, 7));
        projectWorkerList.add(new ProjectWorker(9, 6));
        projectWorkerList.add(new ProjectWorker(10, 5));
        projectWorkerList.add(new ProjectWorker(10, 4));
        projectWorkerList.add(new ProjectWorker(11, 3));
        projectWorkerList.add(new ProjectWorker(12, 6));
        projectWorkerList.add(new ProjectWorker(12, 7));

        try(PreparedStatement statement = connection.prepareStatement("insert into project_worker (project_id, worker_id) VALUES(?, ?)")){
            for (ProjectWorker projectWorker : projectWorkerList){
                statement.setInt(1, projectWorker.getProjectId());
                statement.setInt(2, projectWorker.getWorkerId());
                statement.addBatch();
            }
            statement.executeBatch();
        }
        catch(Exception e){
            loger.error("Error during executing query. Message error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    private static void populateProject(Connection connection) {
        List<Project> projectsList = new ArrayList<>();
        projectsList.add(new Project(1,"Scada", LocalDate.parse("2024-01-01"), LocalDate.parse("2024-03-01")));
        projectsList.add(new Project(2,"PLC app", LocalDate.parse("2024-01-11"), LocalDate.parse("2024-03-21")));
        projectsList.add(new Project(3,"Rocket app", LocalDate.parse("2024-02-11"), LocalDate.parse("2024-03-31")));
        projectsList.add(new Project(1,"Military app", LocalDate.parse("2024-02-01"), LocalDate.parse("2027-03-01")));
        projectsList.add(new Project(1,"And app", LocalDate.parse("2025-02-01"), LocalDate.parse("2026-03-01")));
        projectsList.add(new Project(1,"Sun app", LocalDate.parse("2025-01-01"), LocalDate.parse("2029-06-21")));
        projectsList.add(new Project(4,"Weather app", LocalDate.parse("2025-11-01"), LocalDate.parse("2028-10-01")));
        projectsList.add(new Project(1,"Diagram app", LocalDate.parse("2025-11-21"), LocalDate.parse("2029-03-01")));
        projectsList.add(new Project(5,"Platform 1", LocalDate.parse("2024-11-01"), LocalDate.parse("2025-12-01")));
        projectsList.add(new Project(6,"Web app", LocalDate.parse("2025-08-01"), LocalDate.parse("2026-09-01")));
        projectsList.add(new Project(7,"Calculator", LocalDate.parse("2026-06-01"), LocalDate.parse("2030-06-01")));
        projectsList.add(new Project(7,"App 1", LocalDate.parse("2025-11-20"), LocalDate.parse("2029-03-09")));
        projectsList.add(new Project(4,"Virus to keel rus", LocalDate.parse("2026-01-01"), LocalDate.parse("2031-06-05")));
        projectsList.add(new Project(2,"App 2", LocalDate.parse("2025-04-01"), LocalDate.parse("2028-04-02")));
        projectsList.add(new Project(2,"Web site", LocalDate.parse("2027-01-01"), LocalDate.parse("2029-03-01")));
        projectsList.add(new Project(6,"Mobile app", LocalDate.parse("2026-03-01"), LocalDate.parse("2029-06-01")));
        projectsList.add(new Project(1,"CRM for Nasdaqu", LocalDate.parse("2028-01-28"), LocalDate.parse("2032-08-01")));

        try(PreparedStatement statement = connection.prepareStatement("insert into project (client_id, name, start_date, finish_date) VALUES(?, ?, ?, ?)")){
            for (Project project : projectsList){
                statement.setInt(1, project.getClientId());
                statement.setString(2, project.getName());
                statement.setDate(3, Date.valueOf(project.getStartDate()));
                statement.setDate(4, Date.valueOf(project.getEndDate()));
                statement.addBatch();
            }
            statement.executeBatch();
        }
        catch(Exception e){
            loger.error("Error during executing query. Message error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void populateClients(Connection connection) {
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client("Nadiia"));
        clientList.add(new Client("Andrii"));
        clientList.add(new Client("Oksana"));
        clientList.add(new Client("Tetiana"));
        clientList.add(new Client("Nastia"));
        clientList.add(new Client("Olga"));
        clientList.add(new Client("Makar"));

        try(PreparedStatement statement = connection.prepareStatement("insert into client (NAME) VALUES(?)")){
            for (Client client : clientList){
                statement.setString(1, client.getName());
                statement.addBatch();
            }
            statement.executeBatch();
        }
        catch(Exception e){
            loger.error("Error during executing query. Message error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    private static void populateWorkers(Connection connection){
        List<Worker> workerList = new ArrayList<>();
        workerList.add(new Worker("Viktor", LocalDate.parse("2000-01-01"), Level.Trainee, 980));
        workerList.add(new Worker("Natalia", LocalDate.parse("2000-01-01"), Level.Trainee, 880));
        workerList.add(new Worker("Vasyl", LocalDate.parse("2001-08-01"), Level.Junior, 1200));
        workerList.add(new Worker("Olga", LocalDate.parse("2002-11-01"), Level.Junior, 1300));
        workerList.add(new Worker("Mariia", LocalDate.parse("2000-08-01"), Level.Junior, 1250));
        workerList.add(new Worker("Yevgenii", LocalDate.parse("2010-12-01"), Level.Trainee, 780));
        workerList.add(new Worker("Andrii", LocalDate.parse("2000-01-01"), Level.Senior, 9000));
        workerList.add(new Worker("Anna", LocalDate.parse("2000-01-01"), Level.Senior, 9800));
        workerList.add(new Worker("Vladyslav", LocalDate.parse("2000-09-01"), Level.Senior, 9080));
        workerList.add(new Worker("Olesia", LocalDate.parse("2000-01-03"), Level.Trainee, 960));
        workerList.add(new Worker("Iryna", LocalDate.parse("2000-02-01"), Level.Middle, 7980));
        workerList.add(new Worker("Nadiia", LocalDate.parse("2000-11-01"), Level.Trainee, 950));
        workerList.add(new Worker("Serhii", LocalDate.parse("2002-01-01"), Level.Middle, 6980));
        workerList.add(new Worker("Denys", LocalDate.parse("2008-01-01"), Level.Trainee, 980));
        workerList.add(new Worker("Pavlo", LocalDate.parse("2001-01-01"), Level.Middle, 8000));
        workerList.add(new Worker("Ludmyla", LocalDate.parse("2010-11-01"), Level.Senior, 9980));

        try {
            PreparedStatement statement = connection.prepareStatement("insert into worker (NAME, BIRTHDAY, LEVEL, SALARY)\n" +
                    "VALUES(?, ?, ?, ?)");

            for(Worker worker: workerList){
                statement.setString(1, worker.getName());
                statement.setDate(2, Date.valueOf(worker.getBirthday()));
                statement.setString(3, worker.getLevel().name());
                statement.setInt(4, worker.getSalary());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (Exception e) {
            loger.error("Error during executing query. Message error: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
