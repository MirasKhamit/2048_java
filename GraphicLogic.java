package assignment_Game_2048_Miras_Khamit;

import java.awt.*;

public class GraphicLogic {
	
	//draw game interface method
	public void outputG(int [][] x, DrawingPanel panel, Graphics g, Logic l) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 500);
	    g.setColor(new Color( 160, 160, 160));
	    g.fillRoundRect(0, 0, 400, 100, 15,15);
	    g.setColor(new Color( 90, 90, 90));
	    g.fillRoundRect(0, 100, 400, 400, 15, 15);
	    g.setColor(Color.BLACK);
	    g.setFont(new Font("Monospaced", Font.ITALIC, 34));
	    g.drawString("Score: " + l.getScore(), 40, 60);
	    g.setFont(new Font("Monospaced", Font.ITALIC, 16));
	    g.drawString("inserted unit " + l.getUnitValue() + " in the index [" + l.getInsertIndex() + "]", 40, 90);
	    int pr = 0;
	    int pc = 0;
	    for(int i = 0; i < 4; i++) {
	    	pc = 0;
			for(int j = 0; j < 4; j++) {
			    setValColor(x[i][j], g);
			    g.fillRoundRect(pc+5, pr+105, 90, 90, 15, 15);
			    g.setColor(Color.BLACK);
			    if(x[i][j] > 0) {
				    g.setFont(new Font("Monospaced", Font.PLAIN, getFontV(x[i][j])));
				    g.drawString(String.valueOf(x[i][j]), getPH(x[i][j], pc), getPV(x[i][j], pr));
			    }
			    pc += 100;
			}
			pr += 100;
	    }
	}
	
	//draw Game Over method
	public void outputGOver(DrawingPanel panel, Graphics g, Logic l) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 500);
		g.setColor(Color.WHITE);
	    g.setFont(new Font("Monospaced", Font.ITALIC, 60));
	    g.drawString("GAME OVER", 40, 200);
	    g.setFont(new Font("Monospaced", Font.ITALIC, 20));
	    g.drawString("Your score: " + l.getScore(), 100, 290);
	    g.drawString("Type \"F\" to play again", 60, 320);
	}
	
	//draw Game Won method
	public void outputGameWon(DrawingPanel panel, Graphics g) {
		g.setColor(new Color(255,255,128));
		g.fillRect(0, 0, 400, 500);
		g.setColor(Color.BLACK);
	    g.fillRoundRect(20, 20, 360, 460, 30, 30);
	    g.setColor(new Color(75,0,130));
	    g.fillRoundRect(30, 110, 340, 140, 25, 25);
		g.setColor(Color.WHITE);
	    g.setFont(new Font("Monospaced", Font.ITALIC, 60));
	    g.drawString("YOU WON!", 58, 200);
	    g.setFont(new Font("Monospaced", Font.ITALIC, 18));
	    g.drawString("Type \"C\" to continue game", 60, 300);
	    g.drawString("Type \"F\" to start new game", 55, 320);
	}
	
	//color set for array value(cube)
	public void setValColor(int v, Graphics g) {
		if (v == 0) {
			g.setColor(new Color(120, 120, 120));
		}
		else if (v == 2) {
			g.setColor(new Color(250,250,250));
		}
		else if (v == 4) {
			g.setColor(new Color(255, 255, 128));
		}
		else if (v == 8) {
			g.setColor(new Color(255, 255, 0));
		}
		else if (v == 16) {
			g.setColor(new Color(255, 235, 255));
		}
		else if (v == 32) {
			g.setColor(new Color(255, 235, 128));
		}
		else if (v == 64) {
			g.setColor(new Color(255, 235, 0));
		}
		else if (v == 128) {
			g.setColor(new Color(255, 215, 255));
		}
		else if (v == 256) {
			g.setColor(new Color(255, 215, 128));
		}
		else if (v == 512) {
			g.setColor(new Color(255, 215, 0));
		}
		else if (v == 1024) {
			g.setColor(new Color(255, 195, 255));
		}
		else if (v == 2048) {
			g.setColor(new Color(255, 195, 128));
		}
		else if (v == 4096) {
			g.setColor(new Color(255, 195, 0));
		}
		else if (v == 8192) {
			g.setColor(new Color(255, 175, 255));
		}
		else if (v == 16384) {
			g.setColor(new Color(255, 175, 128));
		}
		else if (v == 32768) {
			g.setColor(new Color(255, 175, 0));
		}
		else {
			g.setColor(new Color(255, 255, 255));
		}

	}
	
	//font size for string(x[i][j]) in cube
	public int getFontV(int v) {
		if (v <10) {
			return 70;
		}
		else if (v < 100) {
			return 62;
		}
		else if (v < 1000) {
			return 46;
		}
		else if (v < 10000) {
			return 38;
		}
		else if (v < 100000) {
			return 20;
		}
		else return 16;
	}
	
	//position string horizontally in cube
	public int getPH(int v, int pc) {
		if (v <10) {
			return pc + 31;
		}
		else if (v < 100) {
			return pc + 15;
		}
		else if (v < 1000) {
			return pc + 8;
		}
		else if (v < 10000) {
			return pc + 3;
		}
		else if (v < 100000) {
			return pc + 2;
		}
		else return pc + 2;
	}
	
	//position string vertically in cube
	public int getPV(int v, int pr) {
		if (v <10) {
			return pr + 175;
		}
		else if (v < 100) {
			return pr + 171;
		}
		else if (v < 1000) {
			return pr + 168;
		}
		else if (v < 10000) {
			return pr + 164;
		}
		else if (v < 100000) {
			return pr + 160;
		}
		else return pr + 156;
	}

}