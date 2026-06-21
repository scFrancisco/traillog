package com.francisco.traillog.model;

public class Workout {

    /* por norma os treinos estao todos com titulo a especificar o que e , acho que deveria depois ate ser not null*/
    private String workoutName;
    /* a descricao que as vezes tem para certas series, ete pode ser null */
    private String description;
    /* km dai double*/
    private double distanceInKm;
    /* segundos*/
    private int timeInSeconds;
    /*training stress score*/
    private Integer tss;
    /*potencia* media e max*/
    private Integer powerAVG;
    private Integer powerMAX;
    /*fc media e max*/
    private Integer hrAVG;
    private Integer hrMAX;
    /*temperatura min,media e max*/
    private Double temperatureMIN;
    private Double temperatureAVG;
    private Double temperatureMAX;
    /*velocidade media e max*/
    private Double speedAVG;
    private Double speedMAX;

    public Workout(String workoutName, double distanceInKm, int timeInSeconds) {
        /*make a switch case to validate args*/
        if(workoutName == null){
            throw new IllegalArgumentException("workoutName cannot be null during construction. Workout details: \ndistance: " + distanceInKm + "\ntime: "  + timeInSeconds);
        } else if(workoutName.isEmpty()){
            throw new IllegalArgumentException("workoutName cannot be empty during construction. Workout details: \ndistance: " + distanceInKm + "\ntime: "  + timeInSeconds);
        } else if (distanceInKm<0) {
            throw new IllegalArgumentException("distanceInKm cannot be negative during construction: " + distanceInKm);
        } else if (timeInSeconds<=0){
            throw new IllegalArgumentException("timeInSeconds cannot be negative  during construction: " + timeInSeconds);
        }
        this.workoutName = workoutName;
        this.distanceInKm = distanceInKm;
        this.timeInSeconds = timeInSeconds;
    }
    public double calculateAVGSpeed(){
        if(this.timeInSeconds <= 0){
            throw new IllegalStateException("timeInSeconds cannot be negative: " + this.timeInSeconds);
        }
        double speedAvg = 0;
        speedAvg = this.distanceInKm /(this.timeInSeconds/3600.0) ;
        return speedAvg;
    }
    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTss(Integer tss) {
        this.tss = tss;
    }

    public void setPowerAVG(Integer powerAVG) {
        this.powerAVG = powerAVG;
    }

    public void setPowerMAX(Integer powerMAX) {
        this.powerMAX = powerMAX;
    }

    public void setHrAVG(Integer hrAVG) {
        this.hrAVG = hrAVG;
    }

    public void setHrMAX(Integer hrMAX) {
        this.hrMAX = hrMAX;
    }

    public void setTemperatureAVG(Double temperatureAVG) {
        this.temperatureAVG = temperatureAVG;
    }

    public void setTemperatureMIN(Double temperatureMIN) {
        this.temperatureMIN = temperatureMIN;
    }

    public void setTemperatureMAX(Double temperatureMAX) {
        this.temperatureMAX = temperatureMAX;
    }
    public void setSpeedAVG(Double speedAVG) {
        this.speedAVG = speedAVG;
    }
    public void setSpeedMAX(Double speedMAX) {
        this.speedMAX = speedMAX;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public String getDescription() {
        return description;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public Integer getTss() {
        return tss;
    }

    public Integer getPowerAVG() {
        return powerAVG;
    }

    public Integer getPowerMAX() {
        return powerMAX;
    }

    public Integer getHrAVG() {
        return hrAVG;
    }

    public Integer getHrMAX() {
        return hrMAX;
    }

    public Double getTemperatureMIN() {
        return temperatureMIN;
    }

    public Double getTemperatureAVG() {
        return temperatureAVG;
    }

    public Double getTemperatureMAX() {
        return temperatureMAX;
    }

    public Double getSpeedAVG() {
        return speedAVG;
    }

    public Double getSpeedMAX() {
        return speedMAX;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "distanceInKm=" + distanceInKm +
                ", workoutName='" + workoutName + '\'' +
                ", timeInSeconds=" + timeInSeconds +
                ", powerAVG=" + getTextValue(powerAVG) +
                ", hrAVG=" + getTextValue(hrAVG) +
                ", powerMAX=" + getTextValue(powerMAX) +
                ", hrMAX=" + getTextValue(hrMAX) +
                ", tss=" + getTextValue(tss) +
                ", speedAVG=" + getTextValue(speedAVG) +
                ", speedMAX=" + getTextValue(speedMAX) +
                '}';
    }

    public String getTextValue(Object value){
        return value != null ? value.toString()  : "N/A";
    }
}
