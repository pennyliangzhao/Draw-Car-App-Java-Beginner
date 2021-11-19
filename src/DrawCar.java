import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JColorChooser;

import ecs100.*;

public class DrawCar {
	// If you need any constants or fields, put them here
//	length
//	height
//	colour of of body(at least 3 colors)
//	colour of wheels(at least 3 colors)
//	position of the car (x,y) on the screen

	public DrawCar() {
		// Set up your buttons here
		UI.println("Welcome to'Draw A Car'APP");
		UI.println("Let's start your journey");
		UI.addButton("Sample", this::DrawCar);
		UI.addButton("Draw Cars", this::DrawCars);
		UI.addButton("Clear", this::clearPanes);
		UI.addButton("Draw Your Car", this::DrawYourCar);

		UI.addButton("Quit", UI::quit);

	}

	// Add your methods here...

	public void DrawCars() {

		this.CustomerChoose(100, 250, 50, 80, Color.BLUE, Color.BLACK);
		this.CustomerChoose(100, 50, 70, 80, Color.GREEN, Color.BLACK);
		this.CustomerChoose(400, 250, 100, 100, Color.CYAN, Color.BLACK);
		this.CustomerChoose(400, 50, 70, 100, Color.RED, Color.BLACK);
	}

	public void DrawCar() {
		UI.println("Start from a sample");
		UI.setColor(Color.red);
		UI.drawRect(175, 150, 100, 150);
		UI.fillRect(175, 150, 100, 150);
		UI.drawRect(175, 250, 300, 100);
		UI.fillRect(175, 250, 300, 100);
		UI.setColor(Color.black);
		UI.fillOval(130, 300, 80, 80);
		UI.fillOval(450, 300, 80, 80);
	}

	public void clearPanes() {
		UI.clearGraphics();
	}

	public void DrawYourCar() {
		UI.println("Now it is your Turn! So");
		double x = UI.askDouble("Position of the car X");
		double y = UI.askDouble("Position of the car Y");
		double length = UI.askDouble("The car's Length");
		double height = UI.askDouble("The car's Height");
		UI.println("Now, choose the colours\nBlack,red,blue,green,yellow");
		String bodyColor = UI.askString("Body's Color");
		String wheelsColor = UI.askString("Wheels' Color");
		Color c1 = chooseColor(bodyColor);
		Color c2 = chooseColor(wheelsColor);

		UI.println("Woohoo, It looks not too bad!");

		this.CustomerChoose(x, y, length, height, c1, c2);
	}

	public Color chooseColor(String color) {
		if (color.equals("red")) {
			return Color.red;
		} else if (color.equals("black")) {
			return Color.black;
		} else if (color.equals("blue")) {
			return Color.blue;
		} else if (color.equals("green")) {
			return Color.green;
		} else if (color.equals("yellow")) {
			return Color.yellow;
		}
		return Color.white;
	}

	public void CustomerChoose(double x, double y, double length, double height, Color bodycolor, Color wheelcolor) {
		UI.setColor(bodycolor);
		UI.drawRect(x, y, length, height);
		UI.fillRect(x, y, length, height);
		UI.drawRect(x, y + height / 2, 2 * length, height / 2);
		UI.fillRect(x, y + height / 2, 2 * length, height / 2);
		UI.setColor(wheelcolor);
		UI.fillOval(x - 40, y + height * 3 / 4, 80, 80);
		UI.fillOval(x + 2 * length - 40, y + height * 3 / 4, 80, 80);

		// extra wheels parts
		UI.setColor(Color.gray);
		UI.setLineWidth(10);
		UI.drawOval(x - 40, y + height * 3 / 4, 80, 80);

		UI.setColor(Color.gray);
		UI.setLineWidth(10);
		UI.drawOval(x + 2 * length - 40, y + height * 3 / 4, 80, 80);

		UI.setColor(Color.white);
		UI.drawOval(x - 15, y + height * 3 / 4 + 20, 30, 30);

		UI.setColor(Color.white);
		UI.drawOval(x + 2 * length - 15, y + height * 3 / 4 + 20, 30, 30);
	}

	public static void main(String[] args) {
		UI.initialise();
		new DrawCar();
	}

}
