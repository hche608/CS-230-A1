package hucklebuckle;

import java.util.Scanner;

class HumanSeeker extends Seeker {
	
	Scanner console; // a human player need a console to play this game

	HumanSeeker( String n, Game g ) {
		super( n, g ); // no change to the constructor
		console = new Scanner(System.in); // one human player can use system,in
	}

	@Override
	void seek() {
		System.out.println( "Hi, I'm " + getName() + ", let's play now!  " );
		System.out.println( reportLocation() );
		// I walk through the grid until I find the hidden object.
		while ( game.myHider.revealTemperature( this ) != Temperature.HUCKLEBUCKLEBEANSTALK){
			System.out.print("Please type a directional character (n, s, e, w or q) followed by a newline: ");
			String t = console.next();
			char cmd = t.charAt(0);
			if( cmd == 'n' || cmd == 'W'){
				if (this.getLocation().y < game.gridSize)
					this.move(0, 1);
			} else if ( cmd == 's' || cmd == 'S'){
				if (this.getLocation().y > 0)
					this.move(0, -1);
			} else if ( cmd == 'e' || cmd == 'D'){
				if (this.getLocation().x < game.gridSize)
					this.move(1, 0);
			} else if ( cmd == 'w' || cmd == 'A'){
				if (this.getLocation().x > 0)
					this.move(-1, 0);
			} else if ( cmd == 'q' || cmd == 'Q'){
				System.out.println( "I give up.  I can't find you!" );
				return;
			}
			System.out.println( reportLocation() );
		}
	}

}