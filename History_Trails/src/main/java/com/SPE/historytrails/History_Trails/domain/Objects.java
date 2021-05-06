package com.SPE.historytrails.History_Trails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Objects {

    @Id
    private String recordid;
    private int likes;




    /**
     * likes of object.
     * @return likes
     */
    public int getLikes() {
       return likes;
    }
    /**
     * update likes of object.
     * @param likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }


    public Objects() {}

}

