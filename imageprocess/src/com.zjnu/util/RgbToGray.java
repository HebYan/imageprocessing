package com.zjnu.util;

import boofcv.alg.color.ColorRgb;
import boofcv.core.image.ConvertImage;
import boofcv.gui.ListDisplayPanel;
import boofcv.gui.image.ShowImages;
import boofcv.io.UtilIO;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.ImageType;
import boofcv.struct.image.Planar;

import java.awt.image.BufferedImage;

/**
 * Example which demonstrates two different ways to convert RGB images to gray
 * scale images. The two methods are weighted and unweighted. The weighted
 * method mimics how human vision works, while the unweighted is much faster.
 * Typically the unweighted method appears more washed out than the weighted
 * method, but still works very well when passed to other computer vision
 * algorithms.
 *
 * @author herbertyang
 */
public class RgbToGray {
	public static void toGray() {
		// load the image and convert it into a BoofCV data type
		BufferedImage buffered = UtilImageIO.loadImage(UtilIO.pathExample("/Users/HERBERTYANG/eclipse-workspace/imgProcess/img/TEST_IMG/th.jpg"));
		Planar<GrayU8> color = ConvertBufferedImage.convertFrom(buffered, true, ImageType.pl(3, GrayU8.class));

		// Declare storage space for converted gray scale images
		GrayU8 weighted = new GrayU8(color.width, color.height);
		GrayU8 unweighted = new GrayU8(color.width, color.height);

		// Now run a benchmark to demonstrate the speed differences between the two
		// approaches. Both are very fast...
		System.out.println("Running benchmark.  Should take a few seconds on a modern computer.\n");
		long startTime;
		int N = 2000;
		startTime = System.nanoTime();
		for (int i = 0; i < N; i++) {
			ColorRgb.rgbToGray_Weighted(color, weighted); // weigh the bands based on how human vision sees each color
		}
		double weightedFPS = N / ((System.nanoTime() - startTime) * 1e-9);

		startTime = System.nanoTime();
		for (int i = 0; i < N; i++) {
			ConvertImage.average(color, unweighted); // this equally averages all the bands together
		}
		double unweightedFPS = N / ((System.nanoTime() - startTime) * 1e-9);

		System.out.println("FPS  averaged over " + N + " images");
		System.out.println("      (higher is better)");
		System.out.println();
		System.out.printf("  weighted    %8.2f\n", weightedFPS);
		System.out.printf("  unweighted  %8.2f\n", unweightedFPS);
		System.out.println();
		System.out.printf("Unweighted is %6.1f times faster.\n", (unweightedFPS / weightedFPS));
		System.out.println();
		System.out.println("WARNING:  This is a poorly implemented microbenchmark "
				+ "and results might not be accurate or consistent.");

		// Display the results
		ListDisplayPanel gui = new ListDisplayPanel();
		gui.addImage(weighted, "加权灰度图");
		gui.addImage(unweighted, "未加权灰度图");
		gui.addImage(buffered, "原图");

		ShowImages.showWindow(gui, "灰度图", true);
	}
}
