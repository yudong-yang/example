package cn.com.duiba.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生实体
 *
 * 
 */
public class Student implements Serializable{

    private static final long serialVersionUID = 2120869894112984147L;

    private int id;
    private String name;
    private int age;
    private Date birthday;
    private double china;
    private double math;
    private double English;
    private double history;
    private double sumScore;//总成绩
    private double avgScore;//平均成绩
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getChina() {
		return china;
	}
	public void setChina(double china) {
		this.china = china;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getEnglish() {
		return English;
	}
	public void setEnglish(double english) {
		English = english;
	}
	public double getHistory() {
		return history;
	}
	public void setHistory(double history) {
		this.history = history;
	}
	public double getSumScore() {
		return getEnglish()+getMath()+getChina()+getHistory() ;
	}
	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
	}
	public double getAvgScore() {
		return (getEnglish()+getMath()+getChina()+getHistory())/4;
	}
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

}