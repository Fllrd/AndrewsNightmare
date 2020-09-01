package com.fllrd.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.fllrd.Handlers.Keys;
import com.fllrd.Main.GamePanel;

public class CompletedState extends GameState {
	

	private Color color;
	private Font EndingFont;
	private Color EndFontColour;
	
	private double angle;
	private BufferedImage image;
	
	public CompletedState(GameStateManager gsm) {
		super(gsm);
		try {
			image = ImageIO.read(
			getClass().getResourceAsStream(
			"/Sprites/Player/PlayerSprites.gif"
			)).getSubimage(0, 0, 40, 40);

			EndFontColour = Color.RED;
			EndingFont = new Font("Times New Roman", Font.PLAIN, 20);

		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public void init() {}
	
	public void update() {
		handleInput();

		angle += 0.1;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		AffineTransform at = new AffineTransform();
		at.translate(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2);
		at.rotate(angle);
		g.drawImage(image, at, null);
		g.setColor(EndFontColour);
		g.setFont(EndingFont);
		g.drawString("You have escaped the Nightmare", 10, 70);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) gsm.setState(GameStateManager.MENUSTATE);
	}

}
