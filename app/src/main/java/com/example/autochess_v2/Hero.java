package com.example.autochess_v2;

public class Hero {
    private String HeroName;
    private String HeroSpec;
    private String HeroClass;
    private int HeroCost;

    public Hero(String heroName, String heroSpec, String heroClass, int heroCost) {
        HeroName = heroName;
        HeroSpec = heroSpec;
        HeroClass = heroClass;
        HeroCost = heroCost;
    }

    public String getHeroName() {
        return HeroName;
    }

    public void setHeroName(String heroName) {
        HeroName = heroName;
    }

    public String getHeroSpec() {
        return HeroSpec;
    }

    public void setHeroSpec(String heroSpec) {
        HeroSpec = heroSpec;
    }

    public String getHeroClass() {
        return HeroClass;
    }

    public void setHeroClass(String heroClass) {
        HeroClass = heroClass;
    }

    public int getHeroCost() {
        return HeroCost;
    }

    public void setHeroCost(int heroCost) {
        HeroCost = heroCost;
    }
}
