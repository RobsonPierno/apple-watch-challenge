package com.avenuecode.applewatchchallenge.utils;

import com.avenuecode.applewatchchallenge.model.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoxGameUtils {

    private List<Box> boxes;
    private Box chosenBox;

    public BoxGameUtils(){
        this.boxes = new ArrayList<>();

        int awardedBoxPosition = new Random().nextInt(3);

        for(int i = 0;i < 3;i++){
            if(awardedBoxPosition == i){
                this.boxes.add(new Box(Boolean.TRUE));
                continue;
            }
            this.boxes.add(new Box(Boolean.FALSE));
        }
        //System.out.println("Game started");
    }

    public void choseOneBox(final int boxNumber){
        if(!this.isBoxGameStarted()){
            //System.out.println("Start the game first!");
            return;
        }

        if(boxNumber > 2 || boxNumber < 0){
            //System.out.println("There is no box in the position " + boxNumber);
            return;
        }

        this.chosenBox = this.boxes.remove(boxNumber);
        //System.out.println("Box number " + boxNumber + " was chosen!");
    }

    public void removeOneNotAwardedBoxFromNotChosenList(){
        if(!this.isBoxGameStarted()){
            //System.out.println("Start the game first!");
            return;
        }

        if(!this.isBoxChosen()){
            //System.out.println("Choose one box first!");
            return;
        }

        for(int i = 0; i < 3; i++){
            Box box = this.boxes.get(i);
            if(!box.isAwarded()){
                this.boxes.remove(box);
                //System.out.println("The box number " + i + " is empty! Do you want change your box?");
                break;
            }
        }
    }

    public void changeChosenBox(){
        if(!this.isBoxGameStarted()){
            //System.out.println("Start the game first!");
            return;
        }

        if(!this.isBoxChosen()){
            //System.out.println("Choose one box first!");
            return;
        }

        if(!this.isThereJustOneBoxInTheList()){
            //System.out.println("Remove one not awarded box from not chosen list");
            return;
        }

        Box oldChosenBox = this.chosenBox;
        Box newChosenBox = this.boxes.remove(0);
        this.chosenBox = newChosenBox;
        this.boxes.add(oldChosenBox);
        //System.out.println("Box changed!");
    }

    public Boolean finishGame(){
        if(!this.isBoxGameStarted()){
            //System.out.println("Start the game first!");
            return Boolean.FALSE;
        }

        if(!this.isBoxChosen()){
            //System.out.println("Choose one box first!");
            return Boolean.FALSE;
        }

        if(!this.isThereJustOneBoxInTheList()){
            //System.out.println("Remove one not awarded box from not chosen list");
            return Boolean.FALSE;
        }

        Boolean isPlayerWinner = this.chosenBox.isAwarded();
        /*String finalMessage = "You loose!";
        if(isPlayerWinner){
            finalMessage = "You win!";
        }
        System.out.println(finalMessage);*/

        return isPlayerWinner;
    }

    private boolean isThereJustOneBoxInTheList() {
        return this.boxes.size() == 1;
    }

    private boolean isBoxChosen() {
        return this.chosenBox != null;
    }

    private Boolean isBoxGameStarted(){
        return this.boxes != null;
    }
}
