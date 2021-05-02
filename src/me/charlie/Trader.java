package me.charlie;

public class Trader {

    String name;
    int money;

    public Trader(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}
