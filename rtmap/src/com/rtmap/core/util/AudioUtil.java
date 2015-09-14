package com.rtmap.core.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

public class AudioUtil {
	
	/**
	 * 获取amr文件的音频长度
	 * @user fushenghua
	 * 2014年7月1日
	 */
	public static int getDurationOfAmr(File file){
		if(!file.getPath().endsWith(".amr")){
			return 0;
		}
		if(!file.exists()){
			return 0;
		}
		int duration = 0;
		try {
			duration = getAmrDuration(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return duration;
	}
	/**
	 * 获取mp3音频文件的长度
	 * @user fushenghua
	 * 2014年7月1日
	 */
	public static int getDurationOfMp3(File file){
		if(!file.getPath().endsWith(".mp3")){
			return 0;
		}
		if(!file.exists()){
			return 0;
		}
		int duration = 0;
		try {
			duration = getMp3TrackLength(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return duration;
	}
	
	/**
	 * 得到amr的时长
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static int getAmrDuration(File file) throws IOException {
		long duration = -1;
		int[] packedSize = { 12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0,
				0, 0 };
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "rw");
			long length = file.length();// 文件的长度
			int pos = 6;// 设置初始位置
			int frameCount = 0;// 初始帧数
			int packedPos = -1;

			byte[] datas = new byte[1];// 初始数据值
			while (pos <= length) {
				randomAccessFile.seek(pos);
				if (randomAccessFile.read(datas, 0, 1) != 1) {
					duration = length > 0 ? ((length - 6) / 650) : 0;
					break;
				}
				packedPos = (datas[0] >> 3) & 0x0F;
				pos += packedSize[packedPos] + 1;
				frameCount++;
			}

			duration += frameCount * 20;// 帧数*20
		} finally {
			if (randomAccessFile != null) {
				randomAccessFile.close();
			}
		}
		return (int)((duration/1000));
	}
	
	private static int getMp3TrackLength(File mp3File) throws IOException {
		try {
			MP3File f = (MP3File)AudioFileIO.read(mp3File);
			MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
			return audioHeader.getTrackLength();	
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		File source = new File("F:/test/advocate_explain.mp3");
//		File source = new File("F:/test/14.amr");
		System.out.println(getDurationOfMp3(source));
	}
}
