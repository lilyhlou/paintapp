package a9;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorUI extends JPanel {

	private JLabel x_label;
	private JLabel y_label;
	private JLabel pixel_info;
	private JButton cloneColor;
	private int xClicked;
	private int yClicked;
	private Pixel pixelClicked;
	private PixelInspectorTool tool;

	public PixelInspectorUI(PixelInspectorTool tool) {
		this.tool = tool;
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		cloneColor = new JButton("Clone");
		setLayout(new GridLayout(3, 1));
		add(x_label);
		add(y_label);
		add(pixel_info);
		add(cloneColor);

		cloneColor.addActionListener(tool);
	}

	public void setInfo(int x, int y, Pixel p) {
		x_label.setText("X: " + x);
		xClicked = x;

		y_label.setText("Y: " + y);
		yClicked = y;

		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));
		pixelClicked = p;

	}

	public Pixel getPixel() {
		return pixelClicked;
	}
}
