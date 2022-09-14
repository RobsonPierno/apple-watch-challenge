package com.avenuecode.applewatchchallenge;

import com.avenuecode.applewatchchallenge.utils.BoxGameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class AppleWatchChallengeApplicationTests {

	private Integer numberOfIterations = 1000000;
	private static Integer neverChangeBoxWins = 0;
	private static Integer alwaysChangeBoxWins = 0;

	@Test
	void boxGameTest(){
		this.alwaysChangeBoxScenario();
		this.neverChangeBoxScenario();
		this.compareAlwaysChangeBoxScenarioWithNeverChangeBoxScenario();
	}

	void neverChangeBoxScenario() {
		for (int i = 0; i <= this.numberOfIterations; i++) {
			BoxGameUtils boxGame = new BoxGameUtils();
			boxGame.choseOneBox(new Random().nextInt(3));
			boxGame.removeOneNotAwardedBoxFromNotChosenList();
			if (boxGame.finishGame()) {
				this.neverChangeBoxWins++;
			}
		}
	}

	void alwaysChangeBoxScenario() {
		for(int i = 0; i < this.numberOfIterations; i++) {
			BoxGameUtils boxGame = new BoxGameUtils();
			boxGame.choseOneBox(new Random().nextInt(3));
			boxGame.removeOneNotAwardedBoxFromNotChosenList();
			boxGame.changeChosenBox();
			if(boxGame.finishGame()){
				this.alwaysChangeBoxWins++;
			}
		}
	}

	void compareAlwaysChangeBoxScenarioWithNeverChangeBoxScenario() {
		System.out.println("\nNever: " + neverChangeBoxWins + " Always: " + alwaysChangeBoxWins);
		String bestOption = neverChangeBoxWins >= alwaysChangeBoxWins ? "never change" : "always change";
		System.out.println("The best option is " + bestOption + " your chosen box by the other.");
		System.out.println("With approximately " + this.getPercentage() + "% chance of getting it right.");
	}

	Integer getPercentage(){
		Integer bigger = neverChangeBoxWins > alwaysChangeBoxWins ? neverChangeBoxWins : alwaysChangeBoxWins;
		Integer lowest = neverChangeBoxWins < alwaysChangeBoxWins ? neverChangeBoxWins : alwaysChangeBoxWins;

		return (bigger * 100) / (bigger+lowest);
	}

}
