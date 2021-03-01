package com.example.demo.listener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewBookEvent {
    private String songName;

    public static CreateNewBookEvent of(String songName){
        return new CreateNewBookEvent(songName);
    }
}
