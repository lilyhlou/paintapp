package a9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UrlUploader extends JPanel implements ActionListener {

	private JTextField url_field;
	private JButton upload_button;
	private JPanel imageUploader;
	private PictureView frame_view;
	private ImageEditorModel models;

	public UrlUploader(PictureView frame_view, ImageEditorModel model) {
		this.frame_view = frame_view;
		models = model;
		setLayout(new BorderLayout());

		imageUploader = new JPanel();
		url_field = new JTextField(10);
		imageUploader.add(new JLabel("URL: "));
		add(url_field);
		imageUploader.add(url_field);

		upload_button = new JButton("Open");
		upload_button.setActionCommand("Open");
		add(upload_button);

		upload_button.addActionListener(this);
		imageUploader.add(upload_button);

		add(imageUploader);
		upload_button.addActionListener(this);
	}

	public void addActionListener(ActionEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String url = url_field.getText();
		try {
			frame_view.setPicture(PictureImpl.readFromURL(url).createObservable());
			models.setCurrent(PictureImpl.readFromURL(url).createObservable());
		} catch (IOException e1) {
		}
		url_field.setText("");

	}
}
