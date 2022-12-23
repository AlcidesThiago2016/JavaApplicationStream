package br.com.cadastro.model;

public class Jogador {
    private String name;
    private String position;

    private Integer age;
    private String currentTeam;
    private Integer goalsScored;

    public Jogador() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", currentTeam='" + currentTeam + '\'' +
                '}';
    }
}
