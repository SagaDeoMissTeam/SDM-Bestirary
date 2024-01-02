package net.sixik.sdm_bestiary.data;

import java.util.ArrayList;
import java.util.List;

public class PlayerData {

    public List<String> favoritePage = new ArrayList<>();
    public List<String> searchList = new ArrayList<>();
    public List<String> unlockedPage = new ArrayList<>();

    public PlayerData(List<String> favoritePage, List<String> searchList, List<String> unlockedPage){
        this.favoritePage = favoritePage;
        this.searchList = searchList;
        this.unlockedPage = unlockedPage;
    }
}
