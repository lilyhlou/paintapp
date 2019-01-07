package a9;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PaintBrushTool implements Tool {

	private PaintBrushToolUI ui;
	private ImageEditorModel model;

	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new PaintBrushToolUI();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		for (int x = e.getX() - ui.getBrushSize() / 2; x <= e.getX() + ui.getBrushSize() / 2; x++) {
			for (int y = e.getY() - ui.getBrushSize() / 2; y <= e.getY() + ui.getBrushSize() / 2; y++) {
				Pixel newColor;
				Pixel modelPix = model.getPixel(x, y);
				System.out.println(ui.getBrushColor().getRed());
				double redVal = ui.getBrushColor().getRed() * ui.getOpacity()
						+ modelPix.getRed() * (1 - ui.getOpacity());
				double greenVal = ui.getBrushColor().getGreen() * ui.getOpacity()
						+ modelPix.getGreen() * (1 - ui.getOpacity());
				double blueVal = ui.getBrushColor().getBlue() * ui.getOpacity()
						+ modelPix.getBlue() * (1 - ui.getOpacity());
				System.out.println(redVal);
				newColor = new ColorPixel(redVal, greenVal, blueVal);
				model.paintAt(x, y, newColor, 1);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for (int x = e.getX() - ui.getBrushSize() / 2; x <= e.getX() + ui.getBrushSize() / 2; x++) {
			for (int y = e.getY() - ui.getBrushSize() / 2; y <= e.getY() + ui.getBrushSize() / 2; y++) {
				Pixel newColor;
				Pixel modelPix = model.getPixel(x, y);
				System.out.println(ui.getBrushColor().getRed());
				double redVal = ui.getBrushColor().getRed() * ui.getOpacity()
						+ modelPix.getRed() * (1 - ui.getOpacity());
				double greenVal = ui.getBrushColor().getGreen() * ui.getOpacity()
						+ modelPix.getGreen() * (1 - ui.getOpacity());
				double blueVal = ui.getBrushColor().getBlue() * ui.getOpacity()
						+ modelPix.getBlue() * (1 - ui.getOpacity());
				System.out.println(redVal);
				newColor = new ColorPixel(redVal, greenVal, blueVal);
				e.getPoint();
				model.paintAt(x, y, newColor, 1);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

}
