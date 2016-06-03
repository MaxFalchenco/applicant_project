package org.sourceit.db;

import org.sourceit.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * You must finish implementation of this class.
 * Methods:
 * -- getApplicant
 * -- getApplicants
 * -- saveApplicant
 * -- deleteApplicant
 * <p>
 * TODO: And your task is add similar methods for Subject, SpecialitySubject, ApplicantResult
 */
public enum ApplicantDBProvider {

    INSTANCE;

    private Connection connection;

    ApplicantDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root", "oper2010");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    public Applicant getApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;
        Applicant applicant = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM applicant WHERE applicant_id=?");
            preparedStatement.setInt(1, (int) applicantId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setProfessionId(resultSet.getInt("profession_id"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicant;
    }

    public List<Applicant> getApplicants() throws Exception {

        Statement statement = null;
        List<Applicant> applicants = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM applicant" +
                    " JOIN profession ON applicant.PROFESSION_ID=profession.PROFESSION_ID");
            Applicant applicant = null;
            Profession profession = null;
            while (resultSet.next()) {
                applicant = new Applicant();
                profession = new Profession();
//                profession.setProfessionName(resultSet.getString("profession_name"));
                profession.setId(resultSet.getInt("profession_id"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setProfessionId(resultSet.getInt("profession_id"));
                applicant.setId(resultSet.getInt("applicant_id"));
                applicants.add(applicant);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return applicants;
    }

    public void saveApplicant(Applicant applicant) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicant.getId() == -1) {
                System.out.println("new applicant");
                preparedStatement = connection.prepareStatement("INSERT INTO applicant (first_name, last_name," +
                        " profession_id, entrance_year) VALUES (?, ?, ?, ?) ");

                preparedStatement.setString(1, applicant.getFirstName());
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setInt(3, (int) (long) applicant.getProfessionId());
                preparedStatement.setInt(4, applicant.getEntranceYear());

            } else {
                System.out.println("update applicant");
                preparedStatement = connection.prepareStatement("UPDATE applicant SET first_name=?, last_name=?," +
                        " profession_id=?, entrance_year=?  WHERE applicant_id=?");

                preparedStatement.setString(1, applicant.getFirstName());
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setInt(3, (int) (long) applicant.getProfessionId());
                preparedStatement.setInt(4, applicant.getEntranceYear());
                preparedStatement.setInt(5, (int) applicant.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant WHERE applicant_id=?");

            preparedStatement.setInt(1, (int) applicantId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    public Profession getProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;
        Profession profession = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM profession WHERE profession_id=?");
            preparedStatement.setInt(1, (int) professionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return profession;
    }


    public List<Profession> getProfessions() throws Exception {

        Statement statement = null;
        List<Profession> professions = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM profession");
           // Applicant applicant = null;
            Profession profession = null;
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
                professions.add(profession);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return professions;
    }

    public void saveProfession(Profession profession) throws Exception{
        PreparedStatement preparedStatement= null;

        try{
            if(profession.getId()== -1){
                System.out.printf("new profession");
                preparedStatement = connection.prepareStatement("INSERT INTO profession (profession_name)" +
                        "VALUES (?)");

                preparedStatement.setString(1,profession.getProfessionName());
            }else {
                System.out.println("update profession");
                preparedStatement = connection.prepareStatement("UPDATE profession SET profession_name=?" +
                        "WHERE profession_id=?");
                preparedStatement.setString(1, profession.getProfessionName());
            }
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new Exception(e);
        }finally {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
        }
    }



    public void deleteProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM profession WHERE profession_id=?");

            preparedStatement.setInt(1, (int) professionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}
