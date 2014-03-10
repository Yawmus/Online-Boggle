package com.peter.boggle;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Board {
	public static final int WIDTH = 4;
	public static final int HEIGHT = 4;
	public static final int SPACE = 5, BORDER = 10;
	public static float offSetX = Gdx.graphics.getWidth()/2 - (WIDTH * Die.WIDTH)/2 - 100 + BORDER;
	public static float offSetY = Gdx.graphics.getHeight()/2 - (HEIGHT * Die.HEIGHT)/2 + 20 + BORDER;
	private Die[][] dice;
	private Color background;
	private ArrayList<Integer[]> loc;
	private ArrayList<Integer> locVal;
	
	public Board(){
		int count = 0;
		loc = new ArrayList<Integer[]>();
		locVal = new ArrayList<Integer>();
		dice = new Die[WIDTH][HEIGHT];
		
		for(int i=0; i<WIDTH; i++)
			for(int j=0; j<HEIGHT; j++){
				loc.add(new Integer[]{i, j});
				locVal.add(count++);
			}
		
		while(!loc.isEmpty()){
			Integer[] cur = loc.remove(Boggle.rand(loc.size(), 0));
			dice[cur[0]][cur[1]] = new Die(Die.NORMAL[(int) (locVal.remove(Boggle.rand(locVal.size(), 0)))][(int) Boggle.rand(6, 0)]);
		}
		
		
		
		background = new Color(0f, .1f, .5f, 1f);
	}
	
	public void draw(){
		Boggle.batch.end();

		Boggle.shape.begin(ShapeType.Filled);
		Boggle.shape.setColor(background);
		Boggle.shape.rect(offSetX - BORDER, offSetY - BORDER, WIDTH*Die.WIDTH + WIDTH*(SPACE-2) + BORDER*2, HEIGHT*Die.HEIGHT + HEIGHT*(SPACE-2) + BORDER*2);
		Boggle.shape.setColor(Color.BLACK);
		Boggle.shape.end();
		
		Boggle.batch.begin();
		
		for(int i=0; i<WIDTH; i++){
			for(int j=0; j<HEIGHT; j++){
				Boggle.batch.draw(dice[i][j], offSetX + Die.WIDTH*i + SPACE*i, offSetY + Die.HEIGHT*j + SPACE*j);
				Boggle.font45.draw(Boggle.batch, dice[i][j].getLetter() == 'Q' ? dice[i][j].getLetter().toString() + "u" : dice[i][j].getLetter().toString(),
						offSetX + Die.WIDTH*i + SPACE*i + Die.WIDTH/2 - dice[i][j].getCharWidth()/2,
						offSetY + Die.HEIGHT*j + SPACE*j + Die.HEIGHT/2 - dice[i][j].getCharHeight()/2 + 33);
			}
		}
	}

	public ArrayList<String> verify(ArrayList<String> words){
		ArrayList<String> temp = new ArrayList<String>();
		while(!words.isEmpty()){
			boolean[][] used = new boolean[WIDTH][HEIGHT];
			break;
		}
		return temp;
	}
}

class Die extends Texture{
	public static final int WIDTH = 64, HEIGHT = 64;
	private float charWidth, charHeight;
	private Character letter;
	
	public Die(Character letter){
		super(Gdx.files.internal("data/dice3.png"));
		this.letter = letter;
		charWidth = Boggle.font45.getBounds(letter == 'Q' ? this.letter.toString() + "u" : this.letter.toString()).width;
		charHeight = Boggle.font45.getBounds(this.letter.toString()).height;
	}
	
	public Character getLetter(){
		return letter;
	}
	
	public float getCharWidth(){
		return charWidth;
	}
	
	public float getCharHeight(){
		return charHeight;
	}
	
	public static final Character[][] NORMAL = {{'A', 'B', 'B', 'J', 'O', 'O'},
												{'E', 'E', 'I', 'N', 'S', 'U'},
												{'D', 'E', 'I', 'L', 'R', 'X'},
												{'H', 'L', 'N', 'N', 'R', 'Z'},
												{'A', 'F', 'F', 'K', 'P', 'S'},
												{'E', 'E', 'G', 'H', 'N', 'W'},
												{'A', 'A', 'E', 'E', 'G', 'N'},
												{'D', 'E', 'L', 'R', 'V', 'Y'},
												{'E', 'H', 'R', 'T', 'V', 'W'},
												{'E', 'L', 'R', 'T', 'T', 'Y'},
												{'A', 'C', 'H', 'O', 'P', 'S'},
												{'C', 'I', 'M', 'O', 'T', 'U'},
												{'A', 'O', 'O', 'T', 'T', 'W'},
												{'D', 'I', 'S', 'T', 'T', 'Y'},
												{'H', 'I', 'M', 'N', 'Q', 'U'},
												{'E', 'I', 'O', 'S', 'T', 'S'}};
}