package g2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, FPressed, CPressed;
	
	//no use
	public void keyTyped(KeyEvent e) {
	}
	
	// if key press - boolean true
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
	    if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			rightPressed = true;

		}
	    if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			upPressed = true;

    	}
	    if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			downPressed = true;
    	}
	    if (key == KeyEvent.VK_F) {
			FPressed = true;

	    }	
	    if (key == KeyEvent.VK_C) {
			CPressed = true;
	    }		
	}
	
	//if key release - boolean false and unlock loop in main
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			leftPressed = false;
			Main.keyUnlock();
			}
	
	    if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			rightPressed = false;
			Main.keyUnlock();
	    }
	
	    if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			upPressed = false;
			Main.keyUnlock();
	    }
	
	    if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			downPressed = false;
			Main.keyUnlock();
	    }	
	    if (key == KeyEvent.VK_F) {
			FPressed = false;
			Main.keyUnlock();
	    }		
	    if (key == KeyEvent.VK_C) {
			CPressed = false;
			Main.keyUnlock();
	    }	
	}
}