package First;

import java.util.NoSuchElementException;

public enum GameSequence {
	Start,
	OldDudeDies,
	GoToCave,
 	End;
	
	public GameSequence getNext() {
		if (ordinal() == values().length - 1)
			throw new NoSuchElementException();
		return values()[ordinal() + 1];
	}
}
