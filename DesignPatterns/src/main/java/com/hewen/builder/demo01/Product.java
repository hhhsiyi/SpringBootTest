package com.hewen.builder.demo01;

/**
 * 2021/10/3
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//房子，抽象
public class Product {
    @Override
    public String toString() {
        return "Product{" +
                "BuildA='" + BuildA + '\'' +
                ", BuildB='" + BuildB + '\'' +
                ", BuildC='" + BuildC + '\'' +
                ", BuildD='" + BuildD + '\'' +
                '}';
    }

    private String BuildA;
    private String BuildB;
    private String BuildC;
    private String BuildD;

    public String getBuildA() {
        return BuildA;
    }

    public void setBuildA(String buildA) {
        BuildA = buildA;
    }

    public String getBuildB() {
        return BuildB;
    }

    public void setBuildB(String buildB) {
        BuildB = buildB;
    }

    public String getBuildC() {
        return BuildC;
    }

    public void setBuildC(String buildC) {
        BuildC = buildC;
    }

    public String getBuildD() {
        return BuildD;
    }

    public void setBuildD(String buildD) {
        BuildD = buildD;
    }
}
