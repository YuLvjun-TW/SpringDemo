package com.example.demo.listener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewSongEvent {
    private String songName;

    public static CreateNewSongEvent of(String songName){
        return new CreateNewSongEvent(songName);
    }
}
