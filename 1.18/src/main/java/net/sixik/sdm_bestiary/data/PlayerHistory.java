package net.sixik.sdm_bestiary.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;

import java.util.ArrayList;
import java.util.List;

public class PlayerHistory {

    public List<String> favoritePage = new ArrayList<>();
    public List<String> searchList = new ArrayList<>();
    public List<String> unlockedPage = new ArrayList<>();
    public void copyFrom(PlayerHistory history){
        this.favoritePage = history.favoritePage;
        this.searchList = history.searchList;
        this.unlockedPage = history.unlockedPage;
    }

    public void saveNBTData(CompoundTag tag){
        ListTag tags = new ListTag();
        for(String s : favoritePage){
            tags.add(StringTag.valueOf(s));
        }

        tag.put("favoritepage", tags);
        tags = new ListTag();
        for(String s : searchList){
            tags.add(StringTag.valueOf(s));
        }
        tag.put("searchlist", tags);

        tags = new ListTag();
        for(String s : unlockedPage){
            tags.add(StringTag.valueOf(s));
        }
        tag.put("unlockedPage", tags);
    }

    public void loadNBTData(CompoundTag tag){
        for (int i = 0; i < ((ListTag) tag.get("favoritepage")).size(); i++){
            favoritePage.add(((ListTag) tag.get("favoritepage")).getString(i));
        }
        for (int i = 0; i < ((ListTag) tag.get("searchlist")).size(); i++){
            searchList.add(((ListTag) tag.get("searchlist")).getString(i));
        }
        for (int i = 0; i < ((ListTag) tag.get("unlockedPage")).size(); i++){
            unlockedPage.add(((ListTag) tag.get("unlockedPage")).getString(i));
        }

    }
}
