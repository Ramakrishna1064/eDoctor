/**
 * 
 */
package com.ensis.mediguru.service.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Ensis
 *
 */
@Service
public class GenerateThumbnailService extends MessageResources {

	/**
	 * 
	 * @param videoFilename
	 * @param thumbFilename
	 */
	public void getThumb(String videoFilename, String thumbFilename) {

		
		int width = 900;
		int height = 900;
		int hour = 0;
		int min = 0;
		float sec = 1;
		String ffmpegApp = getMessage("ffmpegPath");

		try {
			
			ProcessBuilder processBuilder = new ProcessBuilder(ffmpegApp, "-y",
					"-i", videoFilename, "-vframes", "1", "-ss", hour + ":"
							+ min + ":" + sec, "-f", "mjpeg", "-s", width + "*"
							+ height, "-an", thumbFilename);

			ProcessBuilder processBuilder1 = new ProcessBuilder(ffmpegApp,
					"-i", videoFilename, "-r", "25", "-b:a", "128k", "-strict",
					"-2", "-c:v", "libx264", "-preset", "slow", "-s",
					"320x240", "-b:v", "768k", "-ar", "44100", "-c:a", "aac",
					videoFilename);

			Process process = processBuilder.start();
			InputStream stderr = process.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			while ((br.readLine()) != null)
				;
			//process.waitFor();
			

			Process process1 = processBuilder1.start();
			InputStream stderr1 = process1.getErrorStream();
			InputStreamReader isr1 = new InputStreamReader(stderr1);
			BufferedReader br1 = new BufferedReader(isr1);
			while ((br1.readLine()) != null)
				;
			//process1.waitFor();
			//process.destroy();
			//process1.destroy();
			isr.close();
			isr1.close();
			
			//return;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
