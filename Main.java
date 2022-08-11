package assignment_Game_2048_Miras_Khamit;

import java.awt.*;

public class Main {
	private static boolean keylock = false;
	
	
	public static void main(String [] args){
		int fps = 60;
		double drawInterval = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		boolean alreadyWon = false;
		boolean inGame = true;

		Logic l = new Logic();
		GraphicLogic gc = new GraphicLogic();
		//create DrawingPanel 400-500
		DrawingPanel panel = new DrawingPanel(400, 500);
		Graphics g = panel.getGraphics();
		 
		//add keyListener to DrawingPanel
		KeyHandler listener = new KeyHandler();
		panel.addKeyListener(listener);
		 
		//create multiArray( heart of the game)
		int[][] mas = new int[4][4];
		
		//game loop
		while (inGame == true) {
			 mas = new int[4][4];
			 l.setScore0(); //new game
			// if new game 
			if (l.getScore() == 0) {
				l.insertValue(mas);
				l.outputArray(mas);
				gc.outputG(mas, panel, g, l);
			}
		 
			//while game not over
			while (l.containEmpty(mas) || l.canMove(mas)) {
			
				//fps lock( while loop only 60 times per second)
				currentTime = System.nanoTime();
				delta += (currentTime - lastTime) / (drawInterval);
				lastTime = currentTime;
				
				//while loop lock for keylock and fps lock
		        if(delta >= 1 && keylock == false) {
					
					//if game just start
					if (l.getScore() == 0) {
						l.insertValue(mas);
						l.outputArray(mas);
						gc.outputG(mas, panel, g, l);//draw
					}
					
					int[][] oldMas;//for isMasMoved(for insert new value if true)
		
					//if key pressed up or w
					if (listener.upPressed == true) {
						System.out.println("\t Up");// for debug purposes
		
						oldMas = new int [4][4];
						l.copyMas(oldMas, mas);;
						l.moveUp(mas); //move all value in array to key.input direction(equal values will combine)
						if (l.isMoved(oldMas, mas) == true) {
							l.insertValue(mas);
						}
						l.outputArray(mas);
						gc.outputG(mas, panel, g, l);//draw
						keylock = true; // lock while loop until key release
		
		
					}
					//if key pressed down or s
					else if (listener.downPressed == true) {
						System.out.println("\t Down");// for debug purposes
						
						oldMas = new int [4][4];
						l.copyMas(oldMas, mas);;
						l.moveDown(mas);//move all value in array to key.input direction(equal values will combine)
						if (l.isMoved(oldMas, mas) == true) {
							l.insertValue(mas);
						}
						l.outputArray(mas);
						gc.outputG(mas, panel, g, l);//draw
						keylock = true; // lock while loop until key release
					}
					
					//if key pressed left or a
					else if (listener.leftPressed == true) {
						System.out.println("\t Left");// for debug purposes
		
						oldMas = new int [4][4];
						l.copyMas(oldMas, mas);;
						l.moveLeft(mas);//move all value in array to key.input direction(equal values will combine)
						if (l.isMoved(oldMas, mas) == true) {
							l.insertValue(mas);
						}
						l.outputArray(mas);
						gc.outputG(mas, panel, g, l);//draw
						keylock = true; // lock while loop until key release
					}
					
					//if key pressed right or d
					else if (listener.rightPressed == true) {
						System.out.println("\t Right");// for debug purposes
		
						oldMas = new int [4][4];
						l.copyMas(oldMas, mas);;
						l.moveRight(mas);//move all value in array to key.input direction(equal values will combine)
						if (l.isMoved(oldMas, mas) == true) {
							l.insertValue(mas);
						}
						l.outputArray(mas);
						gc.outputG(mas, panel, g, l); //draw
						keylock = true; // lock while loop until key release
		
		
					}
					
					//if you won(2048 in MultiArray)
					if (l.getWon() == false && alreadyWon == false) {
						if (l.contain2048(mas) == true) {
							alreadyWon = true;
							System.out.println("YOU WON!!!\nDo you want to continue a game?\n If yes - enter C\n If no - enter F");
							l.outputArray(mas);
							gc.outputG(mas, panel, g, l);
							gc.outputGameWon(panel, g); //change to gameWin
							while(listener.CPressed == false || listener.FPressed == false) {
								//if key pressed C
								if(listener.CPressed == true) {  //continue
									gc.outputG(mas, panel, g, l);
									break;
		
								}
								//if key pressed F
								else if (listener.FPressed == true){  
									l.setWonFalse();
									alreadyWon = false;
									l.setScore0();// new game
									mas = new int[4][4];
									break;
			
								}
							}
						}
					}
		
					delta--; //release fps lock
		        }
			}
			
			//if game over
			System.out.println("GAME OVER...\n Score: " + l.getScore());
			gc.outputGOver(panel, g, l);
			// if key f pressed - new game
			while(listener.FPressed == false) {
				if (listener.FPressed == true) {
					inGame = true; 
					break;
				}
			}
		}
	}
	
	//unlock loop after key release
	public static void keyUnlock() {
		keylock = false;
	}
}
