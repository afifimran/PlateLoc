package project;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LicensePlateLocation {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat plate = Imgcodecs.imread("C:\\Users\\User\\Documents\\Sem 5\\Image Processing\\vehicle dataset\\vehicle dataset\\test_001.jpg"); // load the plate image

		Mat gray = new Mat();
		Imgproc.cvtColor(plate, gray, Imgproc.COLOR_BGR2GRAY); // convert to grayscale

		

		// Noise removal using bilateral filtering
		Mat filteredImage = new Mat();
		Imgproc.bilateralFilter(gray, filteredImage, 9, 75, 75);

		// Histogram equalization
		Mat histEqImage = new Mat();
		Imgproc.equalizeHist(filteredImage, histEqImage);
		
		//Mat threshold = new Mat();
		//Imgproc.threshold(histEqImage, threshold, 75, 200, Imgproc.THRESH_BINARY); // apply thresholding

		// Morphological opening
		Mat structElem = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
		Mat morphImage = new Mat();
		Imgproc.morphologyEx(histEqImage, morphImage, Imgproc.MORPH_OPEN, structElem, new Point(-1,-1), 14);

		// Subtract morphologically opened image from histogram equalized image
		Mat subtractedImage = new Mat();
		Core.subtract(histEqImage, morphImage, subtractedImage);

		// Thresholding the image
		Mat thresholdImage = new Mat();
		Imgproc.threshold(subtractedImage, thresholdImage, 0, 255, Imgproc.THRESH_OTSU);

		// Edge detection using Canny
		Mat cannyImage = new Mat();
		Imgproc.Canny(thresholdImage, cannyImage, 200, 220);

		// Dilation for edge strengthening
		Mat dilateImage = new Mat();
		Imgproc.dilate(cannyImage, dilateImage, structElem, new Point(-1,-1), 1);

		List<MatOfPoint> contours = new ArrayList<>();
		Mat hierarchy = new Mat();
		Imgproc.findContours(dilateImage, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

		// find the largest contour
		double maxArea = 0;
		int maxIndex = 0;
		for (int i = 0; i < contours.size(); i++) {
			double area = Imgproc.contourArea(contours.get(i));
			if (area > maxArea) {
				maxArea = area;
				maxIndex = i;
			}
		}

		MatOfPoint2f approxCurve = new MatOfPoint2f();
		MatOfPoint2f contour2f = new MatOfPoint2f(contours.get(maxIndex).toArray());
		double approxDistance = Imgproc.arcLength(contour2f, true) * 0.02;
		Imgproc.approxPolyDP(contour2f, approxCurve, approxDistance, true);

		MatOfPoint points = new MatOfPoint(approxCurve.toArray());

		// draw a rectangle around the license plate
		Rect rect = Imgproc.boundingRect(points);
		Imgproc.rectangle(plate, rect.tl(), rect.br(), new Scalar(0, 255, 0), 2);
		// Display the final image
		HighGui.imshow("image", plate);
		HighGui.imshow("grayImage", gray);
		HighGui.imshow("filteredImage", filteredImage);
		HighGui.imshow("histEqImage", histEqImage);
		HighGui.imshow("morphImage", morphImage);
		HighGui.imshow("cannyImage", cannyImage);
		HighGui.imshow("subtractedImage", subtractedImage);
		HighGui.imshow("thresholdImage", thresholdImage);
		HighGui.imshow("dilateImage", dilateImage);
		HighGui.waitKey(0);
		//Imgcodecs.imwrite("C:\\Users\\User\\Desktop\\study\\output.jpg", plate); // save the output image


	}
}